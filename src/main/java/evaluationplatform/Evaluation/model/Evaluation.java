package evaluationplatform.Evaluation.model;

import evaluationplatform.Examen.model.Examen;
import evaluationplatform.Professor.model.Professor;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity(name= "Evaluation")
@Table(name="evaluation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Evaluation {

    @Id
    @SequenceGenerator(name="evaluation_sequence", sequenceName = "evaluation_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_sequence")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="professor_id", referencedColumnName = "id", nullable = false)
    private Professor professor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="examen_id", referencedColumnName = "id", nullable = false)
    private Examen examen;

}
