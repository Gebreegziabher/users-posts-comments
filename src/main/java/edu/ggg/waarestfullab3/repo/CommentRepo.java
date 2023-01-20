package edu.ggg.waarestfullab3.repo;

import edu.ggg.waarestfullab3.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment,Integer>{
}