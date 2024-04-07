package evaluationplatform.Course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCourseRequest {
//aici imi fca prof, dar intai sa fie in baza
    private String title;
    private String description;

}
