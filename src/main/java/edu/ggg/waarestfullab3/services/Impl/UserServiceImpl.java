package edu.ggg.waarestfullab3.services.Impl;

import edu.ggg.waarestfullab3.domain.User;
import edu.ggg.waarestfullab3.domain.dto.PostDto;
import edu.ggg.waarestfullab3.domain.dto.UserDto;
import edu.ggg.waarestfullab3.repo.UserRepo;
import edu.ggg.waarestfullab3.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo repo;
    private ModelMapper modelMapper;
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
        //return repo.findById(id).get();
        return modelMapper.map(repo.findById(id).get(), UserDto.class);
    }

    public List<PostDto> findPostsByUserId(int id){
        return repo.findById(id).get().getPosts().stream().map(p -> modelMapper.map(p,PostDto.class)).collect(Collectors.toList());
    }
    public List<UserDto> findUsersHaveMoreThanOnePost(int number){
        return repo.findUsersHaveMoreThanOnePost(number).stream().map(p -> modelMapper.map(p,UserDto.class)).collect(Collectors.toList());
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
