package edu.ggg.waarestfullab3.services;

import edu.ggg.waarestfullab3.domain.dto.CommentDto;
import edu.ggg.waarestfullab3.domain.dto.PostDto;

import java.util.List;

public interface CommentService {
    public List<CommentDto> findAll();
    CommentDto findById(int id);
    void save(CommentDto p);
    void delete(int id);
    void update(int id, CommentDto p);
}
