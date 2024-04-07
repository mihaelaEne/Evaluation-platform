package evaluationplatform.Course.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import evaluationplatform.Enrolment.model.Enrolment;
import evaluationplatform.Examen.model.Examen;
import evaluationplatform.Professor.model.Professor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name= "Course")
@Table(name="course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data

public class Course {

    @Id
    @SequenceGenerator(name="course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long id;


    private String title;


    private String description;

    public void addExamen(Examen examen){
         this.exams.add(examen);
         examen.setCourse(this);
    }

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Enrolment> enrolments= new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id",referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Professor professor;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Examen> exams= new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course))return  false;
        Course other=(Course) o;
        return id!=null&& id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
