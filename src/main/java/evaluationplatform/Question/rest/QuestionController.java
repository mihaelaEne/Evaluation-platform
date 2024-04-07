package evaluationplatform.Question.rest;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import evaluationplatform.Question.dto.CreateQuestionRequest;
import evaluationplatform.Question.dto.CreateQuestionResp;
import evaluationplatform.Question.model.Question;
import evaluationplatform.Question.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluation_platform")
@Slf4j
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>>getAllQuestions(){
        List<Question>questions=questionService.getAllQustions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CreateQuestionResp> addQuestion(@RequestBody CreateQuestionRequest createQuestionRequest){
        CreateQuestionResp createQuestionResp=questionService.addQuestion(createQuestionRequest);
        return new ResponseEntity<>(createQuestionResp, HttpStatus.CREATED);
    }
}
