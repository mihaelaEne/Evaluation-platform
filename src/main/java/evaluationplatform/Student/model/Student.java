package evaluationplatform.Student.model;

import evaluationplatform.Answer.model.Answer;
import evaluationplatform.Enrolment.model.Enrolment;
import evaluationplatform.User.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity(name= "Student")
@Table(name="student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Student extends User {

    @Id
    @SequenceGenerator(name="student_sequence",sequenceName = "stuudent_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;

    @NotNull
    private String facultate;
    @NotNull
    private String yearOfStudy;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Enrolment> enrolments;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Answer> answers;





}
