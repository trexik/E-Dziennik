package pl.coderslab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.User.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
