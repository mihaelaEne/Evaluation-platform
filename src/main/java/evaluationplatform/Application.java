package evaluationplatform;


import evaluationplatform.Course.model.Course;
import evaluationplatform.Professor.model.Professor;
import evaluationplatform.Professor.repository.ProfessorRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProfessorRepo professorRepo) {
        return args -> {



            Course course = Course.builder()
                    .title("curs1")
                    .description("descriere1")
                    .build();


            Optional<Professor> professorOptional = professorRepo.findById(1L);
            if(professorOptional.isPresent()){
                Professor professor=professorOptional.get();
                professor.addCourse(course);
                professorRepo.saveAndFlush(professor);

            }

            };

        };
    }

