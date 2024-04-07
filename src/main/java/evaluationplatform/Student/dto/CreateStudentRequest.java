package evaluationplatform.Student.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {

    private String name;
    private String email;
    private String password;
    private Date dateOfBirth;
    private String adress;
    private String phoneNr;
    private String facultate;
    private String yearOfStudy;


}
