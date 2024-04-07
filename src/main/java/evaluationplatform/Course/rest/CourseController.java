package evaluationplatform.Course.rest;

import evaluationplatform.Course.dto.CreateCourseRequest;
import evaluationplatform.Course.dto.CreateCourseResponse;
import evaluationplatform.Course.model.Course;
import evaluationplatform.Course.service.CourseService;
import evaluationplatform.Professor.dto.CreateProfessorRequest;
import evaluationplatform.Professor.dto.CreateProfessorResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluation_platform")
@Slf4j
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/allCourses")
    public ResponseEntity<List<Course>>getAllCourses(){
        List<Course> courses=courseService.getAllCourse();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @PostMapping("/createCourse")
    public ResponseEntity<CreateCourseResponse> addCourse(@RequestBody CreateCourseRequest createCourseRequest){
        CreateCourseResponse createCourseResponse=courseService.addCourse(createCourseRequest);
        return new ResponseEntity<>(createCourseResponse, HttpStatus.OK);
    }



}
