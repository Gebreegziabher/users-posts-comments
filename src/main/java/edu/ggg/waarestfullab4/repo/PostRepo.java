package edu.ggg.waarestfullab4.repo;

import edu.ggg.waarestfullab4.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post,Integer>{
    @Query("SELECT p from Post p where p.title=:title")
    List<Post> findByTitle(String title);
}