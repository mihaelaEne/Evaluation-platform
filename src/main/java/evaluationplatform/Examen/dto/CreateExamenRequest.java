package evaluationplatform.Examen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateExamenRequest {
    private String title;
    private Date date;
    private int duration;
}
