package evaluationplatform.Examen.rest;

import evaluationplatform.Examen.dto.CreateExamenRequest;
import evaluationplatform.Examen.dto.CreateExamenRespou;
import evaluationplatform.Examen.model.Examen;
import evaluationplatform.Examen.service.ExamenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluation_platform")
@Slf4j
public class ExamenController {

    private ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }


    @GetMapping("/allExams")
    public ResponseEntity<List<Examen>> getAllExams(){
        List<Examen> exams=examenService.getAllExams();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @PostMapping("/createExam")
    public ResponseEntity<CreateExamenRespou> addExam(@RequestBody CreateExamenRequest createExamenRequest){
        CreateExamenRespou createExamenRespou=examenService.addExam(createExamenRequest);
        return new ResponseEntity<>(createExamenRespou, HttpStatus.OK);
    }
}
