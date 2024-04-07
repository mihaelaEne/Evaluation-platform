package evaluationplatform.Professor.rest;

import evaluationplatform.Professor.dto.CreateProfessorRequest;
import evaluationplatform.Professor.dto.CreateProfessorResponse;
import evaluationplatform.Professor.dto.UpdateProfessorRequest;
import evaluationplatform.Professor.model.Professor;
import evaluationplatform.Professor.service.ProfessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluation_platform")
@Slf4j
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/getAllProf")
    public ResponseEntity<List<Professor>>getAllProf(){
        List<Professor> professors=professorService.getAllProfessors();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }

    @PostMapping("/createProfessor")
    public ResponseEntity<CreateProfessorResponse> adddProfessor(@RequestBody CreateProfessorRequest createProfessorRequest){
        CreateProfessorResponse createProfessorResponse=professorService.addProfessor(createProfessorRequest);
        return new ResponseEntity<>(createProfessorResponse, HttpStatus.OK);
    }

    @PutMapping("/updatePhoneNrProfessor")
    public ResponseEntity<Void>updateProfessorPhoneNr(@RequestBody UpdateProfessorRequest updateProfessorRequest){
        professorService.updateProfessorPhoneNr(updateProfessorRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("deleteProfessor/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        professorService.deleteProfessor(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
