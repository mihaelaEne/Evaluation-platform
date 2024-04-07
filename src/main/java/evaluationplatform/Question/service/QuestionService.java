package evaluationplatform.Question.service;

import evaluationplatform.Question.dto.CreateQuestionRequest;
import evaluationplatform.Question.dto.CreateQuestionResp;
import evaluationplatform.Question.exception.EmptyListErr;
import evaluationplatform.Question.exception.QuestionExist;
import evaluationplatform.Question.model.Question;
import evaluationplatform.Question.repository.QuestionRepo;
import evaluationplatform.Student.dto.CreateStudentRequest;
import evaluationplatform.Student.dto.CreateStudentResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepo questionRepo;

    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public List<Question> getAllQustions() {
        List<Question> all = questionRepo.findAll();

        if (all.size() == 0) {
            throw new EmptyListErr();

        }
        return all;
    }


    @Transactional

    public CreateQuestionResp addQuestion(CreateQuestionRequest createQuestionRequest){
        Optional<Question> questionByIntrebare=questionRepo.findQuestionByIntrebare(createQuestionRequest.getIntrebare());

        if(questionByIntrebare.isPresent()){
            throw new QuestionExist();
        }

        Question question=Question.builder()
                .intrebare(createQuestionRequest.getIntrebare())
                .raspuns(createQuestionRequest.getRaspuns())
                .build();

        Question question1=questionRepo.saveAndFlush(question);

        return CreateQuestionResp.builder().question(question1).build();
    }
}
