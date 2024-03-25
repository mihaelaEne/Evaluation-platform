package evaluationplatform.Question.model;
import evaluationplatform.Examen.model.Examen;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity(name= "evaluationplatform/Question")
@Table(name="question")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data

public class Question {

    @Id
    @SequenceGenerator(name="questionn_sequence", sequenceName = "questionn_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionn_sequence")
    private Long id;


    @NotNull
    private String intrebare;
    @NotNull
    private String raspuns;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examen_id",referencedColumnName = "id", nullable = false)
    private Examen examen;


}
