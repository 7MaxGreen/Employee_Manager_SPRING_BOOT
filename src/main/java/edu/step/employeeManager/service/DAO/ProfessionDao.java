package edu.step.employeeManager.service.DAO;

import edu.step.employeeManager.model.Department;
import edu.step.employeeManager.model.Profession;
import edu.step.employeeManager.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ProfessionDao {
    @Autowired
    ProfessionRepository professionRepository;

    public Profession findById(Integer id) {

        Optional<Profession> profession = professionRepository.findById(id);
        if (profession.isPresent()) {
            return profession.get();
        } else {
            return null; //// !!!!!
        }
    }
}
