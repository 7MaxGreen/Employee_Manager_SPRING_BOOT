package edu.step.employeeManager.service.DAO;

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

    public Company findById(Integer id) {
        Optional<Company> company = this.companyRepository.findById(id);
        if (company.isPresent()) {
            return company.get();
        } else {
            return null; //// !!!!!
        }
    }

    public void create(Company company) {
        this.companyRepository.save(company);
    }

    public void update(Company updatedCompany) throws EntityNotFoundException {
        Optional<Company> foundCompany = this.companyRepository.findById(updatedCompany.getId());

        if( updatedCompany.getName().length() > 2 ||
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
                throw new EntityNotFoundException(updatedCompany.getId());
            }

        } else {
            System.out.println("error");
        }

    }

    public void delete(Integer id) {
        Company company = companyRepository.getById(id);
        companyRepository.delete(company);
    }
}
