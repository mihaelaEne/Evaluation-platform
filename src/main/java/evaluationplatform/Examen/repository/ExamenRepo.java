package evaluationplatform.Examen.repository;

import evaluationplatform.Course.model.Course;
import evaluationplatform.Examen.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamenRepo extends JpaRepository<Examen, Long> {

    Optional<Examen> findExamenByTitle(String title);
}
