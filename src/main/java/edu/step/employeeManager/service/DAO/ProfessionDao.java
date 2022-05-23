package edu.step.employeeManager.service.DAO;

import edu.step.employeeManager.exceptions.CriteriaNotMatchingException;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Profession;
import edu.step.employeeManager.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class ProfessionDao {
    @Autowired
    ProfessionRepository professionRepository;

    public Profession findById(Integer id) throws EntityNotFoundException {

        Optional<Profession> profession = professionRepository.findById(id);
        if (profession.isPresent()) {
            return profession.get();
        } else {
            throw new EntityNotFoundException(profession.get().getId());
        }
    }

    public List<Profession> read() {
        return professionRepository.findAll();
    }

    public void create(Profession profession) throws EntityNotFoundException, CriteriaNotMatchingException {
        if( profession != null) {
            if(profession.getProfessionName().length() < 2 ) {
                throw new CriteriaNotMatchingException(profession.getId());
            } else {
                professionRepository.save(profession);
            }
        } else {
            assert false;
            throw new EntityNotFoundException(profession.getId());
        }
    }

    public void update(Profession updatedProfession) throws EntityNotFoundException, CriteriaNotMatchingException {
        Optional<Profession> foundProfession = this.professionRepository.findById(updatedProfession.getId());

        if( updatedProfession.getProfessionName().length() > 3){
            if(foundProfession.isPresent()) {
                Profession profession = foundProfession.get();
                profession.setProfessionName(updatedProfession.getProfessionName());

                this.professionRepository.save(updatedProfession);
            } else {
                throw new EntityNotFoundException(updatedProfession.getId());
            }

        } else {
            throw new CriteriaNotMatchingException(updatedProfession.getId());
        }
    }

    public void delete(Integer id) {
        Profession profession = professionRepository.getById(id);
        professionRepository.delete(profession);
    }
}
