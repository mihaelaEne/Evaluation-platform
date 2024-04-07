package evaluationplatform.Professor.dto;

import evaluationplatform.Professor.model.Professor;
import evaluationplatform.Professor.repository.ProfessorRepo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProfessorResponse {

    private Professor professor;

    @Builder.Default
    private String message="Profesorul a fost creat cu succes";


}
