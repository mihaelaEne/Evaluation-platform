package evaluationplatform.Professor.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import evaluationplatform.Course.model.Course;
import evaluationplatform.Evaluation.model.Evaluation;
import evaluationplatform.User.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity(name= "Professor")
@Table(name="professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data

public class Professor extends User {
    @Id
    @SequenceGenerator(name="professsor_sequence", sequenceName = "professor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor_sequence")
    private Long id;


    private String departament;

    private String yearsOfExperience;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Course> courses;


    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Evaluation> evaluations;


    public void addCourse(Course course){
        this.courses.add(course);
        course.setProfessor(this);
    }

    public void deleteCourse(Course course){
        if(this.courses.contains(course)){
            this.courses.remove(course);
            course.setProfessor(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor other = (Professor) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
