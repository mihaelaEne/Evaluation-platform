package evaluationplatform.Student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static evaluationplatform.System.Constants.STUDENT_EXIST;
@ResponseStatus(value= HttpStatus.ALREADY_REPORTED)

public class StudentExistErr extends RuntimeException{

    public StudentExistErr(){
        super(STUDENT_EXIST);
    }
}
