package evaluationplatform.Question.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static evaluationplatform.System.Constants.QUESTION_EXIST;

@ResponseStatus(value= HttpStatus.CONFLICT)

public class QuestionExist extends RuntimeException {
    public QuestionExist() {
        super(QUESTION_EXIST);
    }
}
