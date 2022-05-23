package edu.step.employeeManager.service.DAO;

import edu.step.employeeManager.exceptions.CriteriaNotMatchingException;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Company;
import edu.step.employeeManager.model.Employee;
import edu.step.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDao {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void create(Employee emp) throws EntityNotFoundException, CriteriaNotMatchingException {
        if( emp != null) {
            if(     emp.getFirstName().length() < 2  ||
                    emp.getLastName().length() < 2 ||
                    emp.getBirthdate() != null ||
                    emp.getSalary().isNaN()  ||
                    emp.getHireDate() != null ||
                    emp.getPhoneNumber().length() < 3 ||
                    emp.getEmail().contains("@,.") ||
                    emp.getCompany().getName().length() < 2 ||
                    emp.getIdnp().length() < 13 ||
                    emp.getAddress().getStreetNumber() != null ||
                    emp.getAddress().getStreetName().length() < 3 ||
                    emp.getAddress().getApartmentNumber() != null ||
                    emp.getAddress().getHouseNumber() != null ||
                    emp.getDepartment().getDepartmentName().length() < 2 ||
                    emp.getProfession().getProfessionName().length() < 2 ) {
                throw new CriteriaNotMatchingException(emp.getId());
            } else {
                employeeRepository.save(emp);
            }

        } else {
            assert false;
            throw new EntityNotFoundException(emp.getId());
       }
    }

    public List<Employee> read(){
       return employeeRepository.findAll();
    }

    public boolean update(Employee updatedEmployee) throws EntityNotFoundException, CriteriaNotMatchingException {
        Optional<Employee> foundEmployee = employeeRepository.findById(updatedEmployee.getId());

        if(     updatedEmployee.getFirstName().length() < 2  ||
                updatedEmployee.getLastName().length() < 2 ||
                updatedEmployee.getBirthdate() != null ||
                updatedEmployee.getSalary().isNaN()  ||
                updatedEmployee.getHireDate() != null ||
                updatedEmployee.getPhoneNumber().length() < 3 ||
                updatedEmployee.getEmail().contains("@,.") ||
                updatedEmployee.getCompany().getName().length() < 2 ||
                updatedEmployee.getIdnp().length() < 13 ||
                updatedEmployee.getAddress().getStreetNumber() != null ||
                updatedEmployee.getAddress().getStreetName().length() < 3 ||
                updatedEmployee.getAddress().getApartmentNumber() != null ||
                updatedEmployee.getAddress().getHouseNumber() != null ||
                updatedEmployee.getDepartment().getDepartmentName().length() < 2 ||
                updatedEmployee.getProfession().getProfessionName().length() < 2 ) {

            throw new CriteriaNotMatchingException(updatedEmployee.getId());

        } else {
            if (foundEmployee.isPresent()) {
                Employee employee = foundEmployee.get();
                employee.setFirstName(updatedEmployee.getFirstName());
                employee.setlastName(updatedEmployee.getlastName());
                employee.setBirthdate(updatedEmployee.getBirthdate());
                employee.setSalary(updatedEmployee.getSalary());
                employee.setHireDate(updatedEmployee.getHireDate());
                employee.setDismissDate(updatedEmployee.getDismissDate());
                employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
                employee.setEmail(updatedEmployee.getEmail());
                employee.setCompany(updatedEmployee.getCompany());
                employee.setIdnp(updatedEmployee.getIdnp());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setProfession(updatedEmployee.getProfession());

                if (employee.getAddress() != null) {
                    if (updatedEmployee.getAddress() != null) {
                        employee.getAddress().setStreetName(updatedEmployee.getAddress().getStreetName());
                        employee.getAddress().setStreetNumber(updatedEmployee.getAddress().getStreetNumber());
                        employee.getAddress().setApartmentNumber(updatedEmployee.getAddress().getApartmentNumber());
                        employee.getAddress().setHouseNumber(updatedEmployee.getAddress().getHouseNumber());
                        employee.getAddress().setCity(updatedEmployee.getAddress().getCity());
                    }
                } else {
                    employee.setAddress(updatedEmployee.getAddress());
                }
                employeeRepository.save(employee);
                return true;
            }
            else {
                throw new EntityNotFoundException(updatedEmployee.getId());
            }
        }
    }

    public Employee findById(Integer id) throws EntityNotFoundException {
        Optional<Employee> employee = this.employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new EntityNotFoundException(employee.get().getId());
        }
    }

    public void delete(Integer id){
        Employee emp = employeeRepository.getById(id);
        employeeRepository.delete(emp);

    }

}

