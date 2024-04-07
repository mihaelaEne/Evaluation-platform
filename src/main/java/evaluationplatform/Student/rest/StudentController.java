package evaluationplatform.Student.rest;

import evaluationplatform.Student.dto.CreateStudentRequest;
import evaluationplatform.Student.dto.CreateStudentResponse;
import evaluationplatform.Student.dto.UpdateStudentRequest;
import evaluationplatform.Student.model.Student;
import evaluationplatform.Student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluation_platform")
@Slf4j
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>>getAllStudents(){
        List<Student> students=studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @PostMapping("/createStudent")
    public ResponseEntity<CreateStudentResponse> addStudent(@RequestBody CreateStudentRequest createStudentRequest){
        CreateStudentResponse createStudentResponse=studentService.addStudent(createStudentRequest);
        return new ResponseEntity<>(createStudentResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateStudPhoneNr")
    public ResponseEntity<Void>updateStudPhoneNr(@RequestBody UpdateStudentRequest updateStudentRequest){
        studentService.updateStudent(updateStudentRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @DeleteMapping("deleteStudent/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        studentService.deleteStud(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
