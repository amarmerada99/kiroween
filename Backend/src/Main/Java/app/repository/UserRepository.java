//Should generate a query that looks up users based on their username
package app.repository;
import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
    User findByUserId(Integer userId);
    boolean existsByUsername(String username); //check if a username already exists
    Optional<User> findByUsernameAndPassword(String username, String password); //something that could help us validate log ins 
}