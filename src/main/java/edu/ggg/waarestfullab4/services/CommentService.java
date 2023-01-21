package edu.ggg.waarestfullab4.services;

import edu.ggg.waarestfullab4.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {
    public List<CommentDto> findAll();
    CommentDto findById(int id);
    void save(CommentDto p);
    void delete(int id);
    void update(int id, CommentDto p);
}
