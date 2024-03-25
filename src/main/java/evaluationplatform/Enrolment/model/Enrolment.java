package evaluationplatform.Enrolment.model;

import evaluationplatform.Course.model.Course;
import evaluationplatform.Student.model.Student;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity(name= "Enrolment")
@Table(name="enrolment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Enrolment {
    @Id
    @SequenceGenerator(name="enrolment_sequence", sequenceName = "enrolmemt_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enrolment_sequence")
    private Long id;
   @ManyToOne(fetch = FetchType.LAZY)
       @JoinColumn(name="student_id", referencedColumnName = "id", nullable = false)
        private Student student;
   @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="course_id", referencedColumnName = "id", nullable = false)
        private Course course;





}
