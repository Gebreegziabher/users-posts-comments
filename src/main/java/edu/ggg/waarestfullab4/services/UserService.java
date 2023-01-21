package edu.ggg.waarestfullab4.services;

import edu.ggg.waarestfullab4.domain.dto.CommentDto;
import edu.ggg.waarestfullab4.domain.dto.PostDto;
import edu.ggg.waarestfullab4.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();
    UserDto findById(int id);
    List<PostDto> findPostsByUserId(int id);
    PostDto findPostByUserIdByPostId(int userId, int postId);
    List<CommentDto> findCommentsByUserIdByPostId(int userId, int postId);
    CommentDto findCommentByUserIdByPostIdByCommentId(int userId, int postId, int commentId);
    List<UserDto> findUsersHaveMoreThanOnePost(int number);
    List<UserDto> findUsersByPostTitle(String title);
    void save(UserDto u);
    void delete(int id);
    void update(int id, UserDto u);
}
