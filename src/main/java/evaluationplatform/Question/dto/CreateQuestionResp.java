package evaluationplatform.Question.dto;

import evaluationplatform.Question.model.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateQuestionResp {

    private Question question;

    @Builder.Default
    private String message="Intrebarea a fost adaugata cu succes";

}
