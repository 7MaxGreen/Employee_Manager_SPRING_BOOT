package edu.step.employeeManager.repository;

import edu.step.employeeManager.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
