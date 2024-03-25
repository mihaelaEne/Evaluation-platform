package evaluationplatform.Professor.repository;

import evaluationplatform.Professor.model.Professor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Long> {

    @EntityGraph(attributePaths = {"courses","evaluations"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Professor> findById(Long id);



}
