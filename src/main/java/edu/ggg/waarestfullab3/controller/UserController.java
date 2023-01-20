package edu.ggg.waarestfullab3.controller;

import edu.ggg.waarestfullab3.domain.dto.PostDto;
import edu.ggg.waarestfullab3.domain.dto.UserDto;
import edu.ggg.waarestfullab3.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService service;
    UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    public List<UserDto> findAll(@RequestParam(value = "number",required = false) Integer number){
        return number==null?service.findAll():service.findUsersHaveMoreThanOnePost(number);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getPostsByUserId(@PathVariable("id") int id){
        return service.findPostsByUserId(id);
    }

    @PostMapping
    public void save(@RequestBody UserDto userDto){
        service.save(userDto);
    }
}