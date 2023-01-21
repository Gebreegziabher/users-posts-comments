package edu.ggg.waarestfullab4.services.Impl;

import edu.ggg.waarestfullab4.domain.Comment;
import edu.ggg.waarestfullab4.domain.dto.CommentDto;
import edu.ggg.waarestfullab4.repo.CommentRepo;
import edu.ggg.waarestfullab4.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepo repo;
    private ModelMapper modelMapper;
    public CommentServiceImpl(CommentRepo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }
    public List<CommentDto> findAll() {
        List<Comment> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list
                .stream()
                .map( p -> modelMapper.map(p,CommentDto.class))
                .collect(Collectors.toList());
    }
    public CommentDto findById(int id){
        return modelMapper.map(repo.findById(id).get(), CommentDto.class);
    }
    public void save(CommentDto dto){
        Comment comment = new Comment();//modelMapper.map(dto, Post.class);
        comment.setName(dto.getName());
        repo.save(comment);
    }

    @Override
    public void update(int id,  CommentDto p) {
        //repo.update(id, modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
