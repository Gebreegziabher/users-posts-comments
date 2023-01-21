package edu.ggg.waarestfullab4.repo;

import edu.ggg.waarestfullab4.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment,Integer>{
}