package evaluationplatform.Professor.exception;

import static evaluationplatform.System.Constants.PROFESSOR_DOESNT_EXIST;

public class ProfessorDoesntExistErr extends RuntimeException{
    public ProfessorDoesntExistErr() {
        super(PROFESSOR_DOESNT_EXIST);
    }
}
