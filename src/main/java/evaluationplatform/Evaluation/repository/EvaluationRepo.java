package evaluationplatform.Evaluation.repository;

import evaluationplatform.Evaluation.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {

    Optional<Evaluation>getEvalById(Long id);
}
