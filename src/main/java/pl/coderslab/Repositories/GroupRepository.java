package pl.coderslab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Group.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
