package evaluationplatform.Student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static evaluationplatform.System.Constants.STUDENT_DOESNT_EXIST;

@ResponseStatus(value= HttpStatus.NOT_FOUND)

public class StudentDoesntExistErr extends RuntimeException{
    public StudentDoesntExistErr() {
        super(STUDENT_DOESNT_EXIST);
    }
}
