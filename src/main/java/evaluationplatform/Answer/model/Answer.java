package evaluationplatform.Answer.model;

import evaluationplatform.Examen.model.Examen;
import evaluationplatform.Student.model.Student;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity(name= "Answer")
@Table(name="answer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Answer {
    @Id
    @SequenceGenerator(name="answer_sequence", sequenceName = "answer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_sequence")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id", referencedColumnName = "id", nullable = false)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="examen_id", referencedColumnName = "id", nullable = false)
    private Examen examen;
}
