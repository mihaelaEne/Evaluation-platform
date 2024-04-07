package evaluationplatform.Student.service;

import evaluationplatform.Student.dto.CreateStudentRequest;
import evaluationplatform.Student.dto.CreateStudentResponse;
import evaluationplatform.Student.dto.UpdateStudentRequest;
import evaluationplatform.Student.exception.EmptyListErr;
import evaluationplatform.Student.exception.NoUpdateErr;
import evaluationplatform.Student.exception.StudentDoesntExistErr;
import evaluationplatform.Student.exception.StudentExistErr;
import evaluationplatform.Student.model.Student;
import evaluationplatform.Student.repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student>getAllStudents(){
        List<Student>all=studentRepo.findAll();

        if(all.size()==0){
            throw new EmptyListErr();
        }
        return all;
    }


@Transactional
    public CreateStudentResponse addStudent(CreateStudentRequest createStudentRequest){
        Optional<Student> studentByName=studentRepo.findStudentByName(createStudentRequest.getName());

        if(studentByName.isPresent()){
            throw new StudentExistErr();
        }

        Student student=Student.builder()
                .name(createStudentRequest.getName())
                .email(createStudentRequest.getEmail())
                .password(createStudentRequest.getPassword())
                .dateOfBirth(createStudentRequest.getDateOfBirth())
                .adress(createStudentRequest.getAdress())
                .phoneNr(createStudentRequest.getPhoneNr())
                .facultate(createStudentRequest.getFacultate())
                .yearOfStudy(createStudentRequest.getYearOfStudy())
                .build();

        Student student1=studentRepo.saveAndFlush(student);

        return CreateStudentResponse.builder().student(student1).build();
}


@Transactional
    public void updateStudent(UpdateStudentRequest updateStudentRequest){
        Optional<Student>studentOptional=studentRepo.findStudentByName(updateStudentRequest.getName());
        if(studentOptional.isPresent()){
            Student student=studentOptional.get();

            if(!updateStudentRequest.getPhoneNr().equals("")){
                student.setPhoneNr(updateStudentRequest.getPhoneNr());
            }else{
                throw new NoUpdateErr();
            }
        }
}


@Transactional
    public void deleteStud(long id){
        Optional<Student>student=studentRepo.findById(id);
        if(student.isPresent()){
            studentRepo.delete(student.get());
        }else{
            throw new StudentDoesntExistErr();
        }
}

}
