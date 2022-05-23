package edu.step.employeeManager.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column(length = 13, unique = true, nullable = false)
    private String idnp;

    @Column(length = 50, unique = true, nullable = false)
    private String phoneNumber;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Column(length = 25)
    private Double salary;

    @Column(length = 20)
    private LocalDate birthdate;

    @Column(length = 20)
    private LocalDate hireDate;

    @Column(length = 20)
    private LocalDate dismissDate;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Profession profession;

//    @ManyToOne
//    private Gender gender;

    @ManyToOne
    private Company company;


    public Employee() {
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }

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

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idnp='" + idnp + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", email='" + address + '\'' +
                ", salary=" + salary +
                ", birthdate='" + birthdate + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", dismissDate='" + dismissDate + '\'' +
                ", department='" + department + '\'' +
                ", profession='" + profession + '\'' +
                ", company=" + company +
                '}';
    }
}

