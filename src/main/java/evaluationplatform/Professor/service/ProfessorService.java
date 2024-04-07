package evaluationplatform.Professor.service;

import evaluationplatform.Professor.dto.CreateProfessorRequest;
import evaluationplatform.Professor.dto.CreateProfessorResponse;
import evaluationplatform.Professor.dto.UpdateProfessorRequest;
import evaluationplatform.Professor.exception.EmptyListErr;
import evaluationplatform.Professor.exception.NoUpdateErr;
import evaluationplatform.Professor.exception.ProfessorDoesntExistErr;
import evaluationplatform.Professor.exception.ProfessorExistErr;
import evaluationplatform.Professor.model.Professor;
import evaluationplatform.Professor.repository.ProfessorRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepo professorRepo;

    public ProfessorService(ProfessorRepo professorRepo) {
        this.professorRepo = professorRepo;
    }

//aici imi aduce toti userii
    public List<Professor> getAllProfessors(){
        List<Professor> all=professorRepo.findAll();

        if(all.size()==0){
            throw new EmptyListErr();
        }
        return all;
    }


@Transactional
    public CreateProfessorResponse addProfessor(CreateProfessorRequest createProfessorRequest){
    Optional<Professor>professorByName=professorRepo.findByName(createProfessorRequest.getName());

    if(professorByName.isPresent()){
        throw new ProfessorExistErr();
    }


    Professor professor=Professor.builder()
            .name(createProfessorRequest.getName())
            .email(createProfessorRequest.getEmail())
            .password(createProfessorRequest.getPassword())
            .dateOfBirth(createProfessorRequest.getDateOfBirth())
            .adress(createProfessorRequest.getAdress())
            .phoneNr(createProfessorRequest.getPhoneNr())
            .departament(createProfessorRequest.getDepartament())
            .yearsOfExperience(createProfessorRequest.getYearsOfExperience())
            .build();


        Professor professor1=professorRepo.saveAndFlush(professor);
        return CreateProfessorResponse.builder().professor(professor1).build();



}


@Transactional
    public void deleteProfessor(long id){
        Optional<Professor> professor=professorRepo.findById(id);
        if(professor.isPresent()){
            professorRepo.delete(professor.get());
        }else{
            throw new ProfessorDoesntExistErr();
        }
}



@Transactional
    public void updateProfessorPhoneNr(UpdateProfessorRequest updateProfessorRequest){
        Optional<Professor> professorOptional=professorRepo.findByName(updateProfessorRequest.getName());
        if(professorOptional.isPresent()){
            Professor professor=professorOptional.get();

            if(!updateProfessorRequest.getPhoneNr().equals("")){
                professor.setPhoneNr(updateProfessorRequest.getPhoneNr());
            }else {
                throw new NoUpdateErr();
            }
        }
}

}
