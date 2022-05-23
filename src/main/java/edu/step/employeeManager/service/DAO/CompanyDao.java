package edu.step.employeeManager.service.DAO;

import edu.step.employeeManager.exceptions.CriteriaNotMatchingException;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Company;
import edu.step.employeeManager.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class CompanyDao {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> read() {
        return companyRepository.findAll();
    }

    public Company findById(Integer id) throws EntityNotFoundException {
        Optional<Company> company = this.companyRepository.findById(id);
        if (company.isPresent()) {
            return company.get();
        } else {
            throw new EntityNotFoundException(company.get().getId());
        }
    }

    public void create(Company company) throws EntityNotFoundException, CriteriaNotMatchingException {
        if( company != null) {
            if( company.getName().length() < 2 ) {
                throw new CriteriaNotMatchingException(company.getId());
            } else {
                companyRepository.save(company);
            }
        } else {
            assert false;
            throw new EntityNotFoundException(company.getId());
        }
    }

    public void update(Company updatedCompany) throws EntityNotFoundException, CriteriaNotMatchingException {
        Optional<Company> foundCompany = this.companyRepository.findById(updatedCompany.getId());

        if(updatedCompany.getName().length() > 2 ||
            updatedCompany.getEmployeesNumber() > 1 ||
            updatedCompany.getFoundationYear() != null && updatedCompany.getFoundationYear().isBefore(LocalDate.of(1990, 01, 01))
          ){
            if(foundCompany.isPresent()) {
                Company company = foundCompany.get();
                company.setName(updatedCompany.getName());
                company.setEmployeesNumber(updatedCompany.getEmployeesNumber());
                company.setFoundationYear(updatedCompany.getFoundationYear());

                this.companyRepository.save(updatedCompany);
            } else {
                throw new EntityNotFoundException(foundCompany.get().getId());
            }

        } else {
            throw new CriteriaNotMatchingException(updatedCompany.getId());
        }

    }

    public void delete(Integer id) {
        Company company = companyRepository.getById(id);
        companyRepository.delete(company);
    }
}
