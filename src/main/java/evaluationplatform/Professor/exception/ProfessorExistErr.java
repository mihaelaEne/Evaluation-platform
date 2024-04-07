package evaluationplatform.Professor.exception;

import static evaluationplatform.System.Constants.PROFESSOR_EXIST;

public class ProfessorExistErr extends RuntimeException{
    public ProfessorExistErr() {
        super(PROFESSOR_EXIST);
    }
}
