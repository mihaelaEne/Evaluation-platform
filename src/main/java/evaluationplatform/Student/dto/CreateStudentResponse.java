package evaluationplatform.Student.dto;

import evaluationplatform.Student.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentResponse {

    private Student student;

    @Builder.Default
    private String message="Studentul a fost creat cu succes";

}
