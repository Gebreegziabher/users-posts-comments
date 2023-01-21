package edu.ggg.waarestfullab3.services.Impl;

import edu.ggg.waarestfullab3.domain.User;
import edu.ggg.waarestfullab3.domain.dto.CommentDto;
import edu.ggg.waarestfullab3.domain.dto.PostDto;
import edu.ggg.waarestfullab3.domain.dto.UserDto;
import edu.ggg.waarestfullab3.repo.UserRepo;
import edu.ggg.waarestfullab3.services.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepo repo;
    private ModelMapper modelMapper;

    @PersistenceContext
    EntityManager entityManager;

    public UserServiceImpl(UserRepo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }
    public List<UserDto> findAll() {
        List<User> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list
                .stream()
                .map( p -> modelMapper.map(p,UserDto.class))
                .collect(Collectors.toList());
    }
    public UserDto findById(int id){
        User user = repo.findById(id).get();
        return modelMapper.map(user, UserDto.class);
    }

    public List<PostDto> findPostsByUserId(int id){
        return repo.findById(id).get().getPosts().stream().map(p -> modelMapper.map(p,PostDto.class)).collect(Collectors.toList());
    }
    public PostDto findPostByUserIdByPostId(int userId, int postId){
        var post = repo.findById(userId).get().
                getPosts().stream().filter(f -> f.getId() == postId).findFirst().get();
        return post != null ? modelMapper.map(post, PostDto.class) : new PostDto();
    }
    public List<CommentDto> findCommentsByUserIdByPostId(int userId, int postId){
        return repo.findById(userId).get().
                getPosts().stream().filter(f -> f.getId() == postId).findFirst().get().
                getComments().stream().map(p -> modelMapper.map(p, CommentDto.class)).collect(Collectors.toList());
    }
    public CommentDto findCommentByUserIdByPostIdByCommentId(int userId, int postId, int commentId){
        var comment = repo.findById(userId).get().
                getPosts().stream().filter(f -> f.getId() == postId).findFirst().get().
                getComments().stream().filter(f -> f.getId() == commentId).findFirst().get();
        return comment != null ? modelMapper.map(comment, CommentDto.class) : new CommentDto();
    }

    public List<UserDto> findUsersHaveMoreThanOnePost(int number){
        return repo.findUsersHaveMoreThanOnePost(number).stream().map(p -> modelMapper.map(p,UserDto.class)).collect(Collectors.toList());
    }
    public List<UserDto> findUsersByPostTitle(String title){
        return repo.findUsersByPostTitle(title).stream().map(p -> modelMapper.map(p,UserDto.class)).collect(Collectors.toList());
    }
    public void save(UserDto dto){
        User user = new User();modelMapper.map(dto, User.class);
        user.setName(dto.getName());
        repo.save(user);
    }

    @Override
    public void update(int id,  UserDto dto) {
        //repo.update(id, modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
