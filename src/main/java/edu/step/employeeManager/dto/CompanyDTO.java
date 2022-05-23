package edu.step.employeeManager.dto;

import edu.step.employeeManager.model.Employee;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Set;

public class CompanyDTO {

    private Integer id;
    private String name;
    private LocalDate foundationYear;
    private Integer employeesNumber;
    private Set<Integer> employees;


    public CompanyDTO() {
    }

    public CompanyDTO(Integer id, String name, LocalDate foundationYear, Integer employeesNumber, Set<Integer> employees) {
        this.id = id;
        this.name = name;
        this.foundationYear = foundationYear;
        this.employeesNumber = employeesNumber;
        this.employees = employees;
    }

    public LocalDate getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(LocalDate foundationYear) {
        this.foundationYear = foundationYear;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Integer> employees) {
        this.employees = employees;
    }
}
