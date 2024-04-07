package evaluationplatform.Examen.dto;

import evaluationplatform.Examen.model.Examen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateExamenRespou {
    private Examen examen;

    @Builder.Default
    private String message="Examenul a fost adaugat in baza de date";
}
