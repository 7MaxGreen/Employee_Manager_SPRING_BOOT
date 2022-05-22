package edu.step.employeeManager.repository;

import edu.step.employeeManager.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByNameLike(String name);


}
