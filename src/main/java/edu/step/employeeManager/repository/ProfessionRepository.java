package edu.step.employeeManager.repository;

import edu.step.employeeManager.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
}
