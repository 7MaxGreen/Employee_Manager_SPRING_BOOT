package edu.step.employeeManager.dto;

import edu.step.employeeManager.model.Department;

import java.util.List;
import java.util.Set;

public class DepartmentDTO {

    private Integer id;
    private String departmentName;
    private Integer employeesNumber;

    private Set<Integer> employees;

    public DepartmentDTO() {

    }


    public DepartmentDTO(Integer id, String departmentName, Integer employeesNumber, Set<Integer> employees) {
        this.id = id;
        this.departmentName = departmentName;
        this.employeesNumber = employeesNumber;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public Set<Integer> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Integer> employees) {
        this.employees = employees;
    }


}
