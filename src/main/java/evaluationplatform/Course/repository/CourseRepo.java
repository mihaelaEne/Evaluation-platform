package evaluationplatform.Course.repository;

import evaluationplatform.Course.model.Course;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

   @EntityGraph(attributePaths = {"enrolments", "exams"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Course> findCourseByTitle(String title);
}
