package evaluationplatform.Student.repository;

import evaluationplatform.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByName(String name);


}
