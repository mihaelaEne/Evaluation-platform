package evaluationplatform.Examen.service;


import evaluationplatform.Examen.dto.CreateExamenRequest;
import evaluationplatform.Examen.dto.CreateExamenRespou;
import evaluationplatform.Examen.model.Examen;
import evaluationplatform.Examen.repository.ExamenRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenService {

    private ExamenRepo examenRepo;

    public ExamenService(ExamenRepo examenRepo) {
        this.examenRepo = examenRepo;
    }

    public List<Examen> getAllExams(){
        List<Examen> all=examenRepo.findAll();
        if(all.size()==0){
            throw new RuntimeException();
        }
        return all;
    }

    @Transactional
    public CreateExamenRespou addExam(CreateExamenRequest createExamenRequest){
        Optional<Examen> examenByTitle=examenRepo.findExamenByTitle(createExamenRequest.getTitle());

        if(examenByTitle.isPresent()){
            throw new RuntimeException();
        }


        Examen examen=Examen.builder()
                .title(createExamenRequest.getTitle())
                .date(createExamenRequest.getDate())
                .duration(createExamenRequest.getDuration())
                .build();

        Examen examen1=examenRepo.saveAndFlush(examen);

        return CreateExamenRespou.builder().examen(examen1).build();
    }


}
