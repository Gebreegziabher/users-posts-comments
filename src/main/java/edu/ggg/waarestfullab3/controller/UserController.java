package edu.ggg.waarestfullab3.controller;

import edu.ggg.waarestfullab3.domain.Comment;
import edu.ggg.waarestfullab3.domain.dto.CommentDto;
import edu.ggg.waarestfullab3.domain.dto.PostDto;
import edu.ggg.waarestfullab3.domain.dto.UserDto;
import edu.ggg.waarestfullab3.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService service;
    UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<UserDto> findAll(@RequestParam(value = "number",required = false) Integer number){
        return number==null?service.findAll():service.findUsersHaveMoreThanOnePost(number);
    }
    @GetMapping("/users/byposttitle")
    public List<UserDto> findUsersByPostTitle(@RequestParam(value = "title",required = true) String title){
        return service.findUsersByPostTitle(title);
    }

    @GetMapping("/users/{user_id}/posts/{post_id}")
    public PostDto findPostByUserIdByPostId(@PathVariable("user_id") int userId, @PathVariable("post_id") int postId){
        return service.findPostByUserIdByPostId(userId, postId);
    }

    @GetMapping("/users/{user_id}/posts/{post_id}/comments")
    public List<CommentDto> findCommentsByUserIdByPostId(@PathVariable("user_id") int userId, @PathVariable("post_id") int postId){
        return service.findCommentsByUserIdByPostId(userId, postId);
    }

    @GetMapping("/users/{user_id}/posts/{post_id}/comments/{comment_id}")
    public CommentDto findCommentByUserIdByPostIdByCommentId(@PathVariable("user_id") int userId, @PathVariable("post_id") int postId, @PathVariable("comment_id") int commentId){
        return service.findCommentByUserIdByPostIdByCommentId(userId, postId, commentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") int id){
        service.delete(id);
    }

    @GetMapping("/users/{id}")
    public UserDto getById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<PostDto> getPostsByUserId(@PathVariable("id") int id){
        return service.findPostsByUserId(id);
    }

    @PostMapping("/users")
    public void save(@RequestBody UserDto userDto){
        service.save(userDto);
    }
}