package pl.coderslab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Subject.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
