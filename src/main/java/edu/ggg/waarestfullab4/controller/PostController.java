package edu.ggg.waarestfullab4.controller;

import edu.ggg.waarestfullab4.domain.dto.PostDto;
import edu.ggg.waarestfullab4.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/v1/posts"))
public class PostController {
    private final PostService service;
    public PostController(PostService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> findAll(@RequestParam(value = "title",required = false) String title){
        return title==null?service.findAll():service.findByTitle(title);
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable("id") int id){
        return service.findById(id);
    }
}
