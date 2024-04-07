package evaluationplatform;


import evaluationplatform.Answer.model.Answer;
import evaluationplatform.Course.model.Course;
import evaluationplatform.Course.repository.CourseRepo;
import evaluationplatform.Evaluation.model.Evaluation;
import evaluationplatform.Evaluation.repository.EvaluationRepo;
import evaluationplatform.Examen.model.Examen;
import evaluationplatform.Examen.repository.ExamenRepo;
import evaluationplatform.Professor.model.Professor;
import evaluationplatform.Professor.repository.ProfessorRepo;
import evaluationplatform.Question.model.Question;
import evaluationplatform.Question.repository.QuestionRepo;
import evaluationplatform.Question.service.QuestionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.QuerydslWebConfiguration;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CourseRepo courseRepo, QuestionRepo questionRepo, ExamenRepo examenRepo) {
        return args -> {

            Course course = Course.builder()
                    .title("test adaugare Curs")
                    .description("descriere curs")
                    .build();

            Question question=Question.builder()
                    .intrebare("inrebare test")
                    .raspuns("raspuns test")
                    .build();


            Examen examen=Examen.builder()
                    .title("examen1")
                    .course(course)
//                    .questions(question)
                    .duration(50)
                    .build();
//            questionRepo.saveAndFlush(question);
//            examenRepo.saveAndFlush(examen);
          courseRepo.saveAndFlush(course);




//
//            Optional<Professor> professorOptional = professorRepo.findById(1L);
//            if(professorOptional.isPresent()){
//                Professor professor=professorOptional.get();
//                professor.addCourse(course);
//                professorRepo.saveAndFlush(professor);
//
//            }









           };

        };
    }

