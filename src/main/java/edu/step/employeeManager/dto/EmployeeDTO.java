package edu.step.employeeManager.dto;
import edu.step.employeeManager.model.Department;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeDTO {
    private Integer id;
    private String firstName;
    private String lastName;

    private String idnp;

    private String phoneNumber;

    private String email;

    private Double salary;

    private LocalDate birthdate;

    private LocalDate hireDate;

    private LocalDate dismissDate;

    private Integer department;

//    private Gender gender;
    private Integer company;

    private AddressDTO address;

    private Integer profession;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String firstName, String lastName, String idnp, String phoneNumber, String email, LocalDate birthdate, Integer department, Integer company, AddressDTO address, Integer profession) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idnp = idnp;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthdate = birthdate;
        this.department = department;
        this.company = company;
        this.address = address;
        this.profession = profession;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdnp() {
        return idnp;
    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getDismissDate() {
        return dismissDate;
    }

    public void setDismissDate(LocalDate dismissDate) {
        this.dismissDate = dismissDate;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public Integer getProfession() {
        return profession;
    }

    public void setProfession(Integer profession) {
        this.profession = profession;
    }
}
