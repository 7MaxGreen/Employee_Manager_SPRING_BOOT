package edu.step.employeeManager.service.DAO;

import edu.step.employeeManager.model.Company;
import edu.step.employeeManager.model.Department;
import edu.step.employeeManager.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentDao {

    @Autowired
    DepartmentRepository departmentRepository;

    public void create(Department department) {
        departmentRepository.save(department);
    }

    public List<Department> read() {
        return departmentRepository.findAll();
    }

    public void update(Department updatedDepartment) {
        Optional<Department> foundDepartment = departmentRepository.findById(updatedDepartment.getId());

        if(updatedDepartment.getDepartmentName().length() > 3) {
            if (foundDepartment.isPresent()) {
                Department dep = foundDepartment.get();
                dep.setDepartmentName(updatedDepartment.getDepartmentName());
                dep.setEmployeesNumber(updatedDepartment.getEmployeesNumber());
                departmentRepository.save(dep);
            }
        } else {
            System.out.println("error");
        }
    }

    public void delete(Integer id) {
        Optional<Department> foundDepartment = departmentRepository.findById(id);
        foundDepartment.ifPresent(department -> departmentRepository.delete(department));
    }

    public Department findById(Integer id) {

        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        } else {
            return null; //// !!!!!
        }
    }
}
