package edu.ggg.waarestfullab4.repo;

import edu.ggg.waarestfullab4.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u where size(u.posts) > :number")
    List<User> findUsersHaveMoreThanOnePost(int number);

    @Query("SELECT u FROM User u where (select p from u.posts p where p.title = :title) != null")
    List<User> findUsersByPostTitle(String title);
}
