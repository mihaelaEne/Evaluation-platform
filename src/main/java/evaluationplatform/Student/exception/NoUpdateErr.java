package evaluationplatform.Student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static evaluationplatform.System.Constants.NO_UPDATE;
@ResponseStatus(value= HttpStatus.BAD_REQUEST)

public class NoUpdateErr extends RuntimeException{
    public NoUpdateErr() {
        super(NO_UPDATE);
    }
}
