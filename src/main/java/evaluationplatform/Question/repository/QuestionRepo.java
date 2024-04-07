package evaluationplatform.Question.repository;

import evaluationplatform.Question.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

    Optional<Question>findQuestionByIntrebare(String intrebare);
}
