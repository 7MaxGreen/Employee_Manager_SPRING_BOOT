package edu.step.employeeManager.service.DTOservice;

import edu.step.employeeManager.dto.DepartmentDTO;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Department;
import edu.step.employeeManager.service.DAO.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class DepartmentDTOService {
    @Autowired
    private DepartmentDao departmentDao;

    public List<DepartmentDTO> getAll() {
        List<Department> departments = departmentDao.read();
        return departments.stream()
                .map(department -> {
                    Set<Integer> departmentIDs = department.getEmployees().stream().map(comp -> comp.getId()).collect(Collectors.toSet());

                    return new DepartmentDTO(department.getId(), department.getDepartmentName(), department.getEmployeesNumber(),  departmentIDs);
                })
                .collect(Collectors.toList());
    }

    public void update(DepartmentDTO departmentDTO) throws EntityNotFoundException {
        Department editedDepartment = new Department();

        editedDepartment.setDepartmentName(departmentDTO.getDepartmentName());
        editedDepartment.setEmployeesNumber(departmentDTO.getEmployeesNumber());

        departmentDao.update(editedDepartment);
    }

    public void create(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setEmployeesNumber(departmentDTO.getEmployeesNumber());

        departmentDao.create(department);
    }

    public boolean delete(Integer id){
        Optional<Department> foundDepartment= Optional.ofNullable(departmentDao.findById(id));
        if(foundDepartment.isPresent()) {
            departmentDao.delete(foundDepartment.get().getId());
            return true;
        }
        return false;
    }
}
