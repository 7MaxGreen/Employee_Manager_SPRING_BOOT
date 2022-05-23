package edu.step.employeeManager.service.DTOservice;

import edu.step.employeeManager.dto.CompanyDTO;
import edu.step.employeeManager.exceptions.CriteriaNotMatchingException;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Company;
import edu.step.employeeManager.service.DAO.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CompanyDTOService {

    @Autowired
    private CompanyDao companyDao;

    public List<CompanyDTO> getAll() {
        List<Company> companies = companyDao.read();
        return companies.stream()
                .map(company -> {
                    Set<Integer> companyIDs = company.getEmployees().stream().map(emp -> emp.getId()).collect(Collectors.toSet());

                    return new CompanyDTO(company.getId(), company.getName(), company.getFoundationYear(), company.getEmployeesNumber(),  companyIDs);
                })
                .collect(Collectors.toList());
    }

    public void create(CompanyDTO companyDTO) throws EntityNotFoundException, CriteriaNotMatchingException {

        Company company = new Company();

        company.setName(companyDTO.getName());
        company.setFoundationYear(companyDTO.getFoundationYear());
        company.setEmployeesNumber(companyDTO.getEmployeesNumber());

        companyDao.create(company);
    }

    public void update(CompanyDTO companyDTO) throws EntityNotFoundException, CriteriaNotMatchingException {
        Company editedCompany = new Company();

        editedCompany.setName(companyDTO.getName());
        editedCompany.setFoundationYear(companyDTO.getFoundationYear());
        editedCompany.setEmployeesNumber(companyDTO.getEmployeesNumber());

        companyDao.update(editedCompany);
    }



    public boolean delete(Integer id) throws EntityNotFoundException {
        Optional<Company> foundCompany = Optional.ofNullable(companyDao.findById(id));
        if(foundCompany.isPresent()) {
            companyDao.delete(foundCompany.get().getId());
            return true;
        }
        return false;
    }


}
