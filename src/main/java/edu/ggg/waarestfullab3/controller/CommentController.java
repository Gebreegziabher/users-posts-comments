package edu.ggg.waarestfullab3.controller;

import edu.ggg.waarestfullab3.domain.dto.CommentDto;
import edu.ggg.waarestfullab3.domain.dto.PostDto;
import edu.ggg.waarestfullab3.services.CommentService;
import edu.ggg.waarestfullab3.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/v1/comments"))
public class CommentController {
    private final CommentService service;
    public CommentController(CommentService service) {
        this.service = service;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CommentDto> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CommentDto getById(@PathVariable("id") int id){
        return service.findById(id);
    }
}
