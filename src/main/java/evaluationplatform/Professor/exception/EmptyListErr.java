package evaluationplatform.Professor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static evaluationplatform.System.Constants.EMPTY_LIST_PROFESSOR;
@ResponseStatus(value= HttpStatus.NOT_FOUND)

public class EmptyListErr extends RuntimeException{
    public EmptyListErr() {
        super(EMPTY_LIST_PROFESSOR);
    }
}
