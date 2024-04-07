package evaluationplatform.Course.service;


import evaluationplatform.Course.dto.CreateCourseRequest;
import evaluationplatform.Course.dto.CreateCourseResponse;
import evaluationplatform.Course.exception.CourseExistErr;
import evaluationplatform.Course.exception.EmptyListErr;
import evaluationplatform.Course.model.Course;
import evaluationplatform.Course.repository.CourseRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getAllCourse(){
        List<Course> all=courseRepo.findAll();
        if(all.size()==0){
            throw new EmptyListErr();
        }
        return all;
    }

    @Transactional
    public CreateCourseResponse addCourse(CreateCourseRequest createCourseRequest){
        Optional<Course>courseByName=courseRepo.findCourseByTitle(createCourseRequest.getTitle());

        if(courseByName.isPresent()){
            throw new CourseExistErr();
        }

        Course course=Course.builder()
                .title(createCourseRequest.getTitle())
                .description(createCourseRequest.getDescription())
                .build();

        Course course1=courseRepo.saveAndFlush(course);

        return CreateCourseResponse.builder().course(course1).build();
    }

}
