package edu.step.employeeManager.dto;

import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class ProfessionDTO {
    private Integer id;
    private String professionName;
    private Set<Integer> employees;

    public ProfessionDTO() {

    }
    public ProfessionDTO(Integer id, String professionName, Set<Integer> employees) {
        this.id = id;
        this.professionName = professionName;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Set<Integer> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Integer> employees) {
        this.employees = employees;
    }
}
