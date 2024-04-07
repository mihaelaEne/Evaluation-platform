package evaluationplatform.Course.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static evaluationplatform.System.Constants.COURSE_EXIST;



public class CourseExistErr extends RuntimeException{

    public CourseExistErr() {
        super(COURSE_EXIST);
    }
}
