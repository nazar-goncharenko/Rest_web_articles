package article.com.Reposetories;


import article.com.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    List<User> getAllBy();

    User getByEmail(String email);
}
