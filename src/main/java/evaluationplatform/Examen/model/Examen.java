package evaluationplatform.Examen.model;

import evaluationplatform.Answer.model.Answer;
import evaluationplatform.Course.model.Course;
import evaluationplatform.Evaluation.model.Evaluation;
import evaluationplatform.Question.model.Question;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.Set;

@Entity(name= "Examen")
@Table(name="examen")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Examen {

    @Id
    @SequenceGenerator(name="examen_sequence", sequenceName = "examen_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "examen_sequence")
    private Long id;

    private String title;
    private Date date;
    private int duration;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",referencedColumnName = "id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Question> questions;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Answer> answers;


    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Evaluation> evaluations;

}
