package edu.step.employeeManager.service.DAO;

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

    public void create(Employee emp) {
        employeeRepository.save(emp);
    }

    public List<Employee> read(){
       return employeeRepository.findAll();
    }

    public boolean update(Employee updatedEmployee) throws EntityNotFoundException{
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
            System.out.println("error");
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
            throw new EntityNotFoundException(updatedEmployee.getId());
        }

        return true;
    }

    public Employee findById(Integer id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            return null; //// !!!!!
        }
    }

    public void delete(Integer id){
        Employee emp = employeeRepository.getById(id);
        employeeRepository.delete(emp);

//        Optional<Employee> foundEmployee = employeeRepository.findById(id);
//        if(foundEmployee.isPresent()) {
//            employeeRepository.delete(foundEmployee.get());
//            return true;
//        }
//        return false;
    }

}

