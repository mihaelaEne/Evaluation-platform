package evaluationplatform.Course.dto;

import evaluationplatform.Course.model.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCourseResponse {
    private Course course;

    @Builder.Default
    private String message="Cursul a fost adaugat in baza de date";
}
