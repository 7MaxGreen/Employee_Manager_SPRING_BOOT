package edu.step.employeeManager.service.DTOservice;

import edu.step.employeeManager.dto.DepartmentDTO;
import edu.step.employeeManager.dto.ProfessionDTO;
import edu.step.employeeManager.exceptions.CriteriaNotMatchingException;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Department;
import edu.step.employeeManager.model.Profession;
import edu.step.employeeManager.service.DAO.ProfessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProfessionDTOService {
    @Autowired
    private ProfessionDao professionDao;

    public List<ProfessionDTO> getAll() {
        List<Profession> professions = professionDao.read();
        return professions.stream()
                .map(profession -> {
                    Set<Integer> professionIds = profession.getEmployees().stream().map(prof -> prof.getId()).collect(Collectors.toSet());

                    return new ProfessionDTO(profession.getId(), profession.getProfessionName(), professionIds);
                })
                .collect(Collectors.toList());
    }

    public void create(ProfessionDTO professionDTO) throws CriteriaNotMatchingException, EntityNotFoundException {
        Profession profession = new Profession();
        profession.setProfessionName(professionDTO.getProfessionName());

        professionDao.create(profession);
    }

    public void update(ProfessionDTO professionDTO) throws EntityNotFoundException, CriteriaNotMatchingException {
        Profession editedProfession = new Profession();
        editedProfession.setProfessionName(professionDTO.getProfessionName());

        professionDao.update(editedProfession);
    }



    public boolean delete(Integer id) throws EntityNotFoundException {
        Optional<Profession> foundProfession = Optional.ofNullable(professionDao.findById(id));
        if (foundProfession.isPresent()) {
            professionDao.delete(foundProfession.get().getId());
            return true;
        }
        return false;
    }
}
