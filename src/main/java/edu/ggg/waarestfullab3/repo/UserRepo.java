package edu.ggg.waarestfullab3.repo;

import edu.ggg.waarestfullab3.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {
    @Query("SELECT distinct u FROM User u GROUP BY u.name HAVING COUNT(u.posts) > :number")
    List<User> findUsersHaveMoreThanOnePost(int number);
}
