package pl.coderslab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Grade.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
