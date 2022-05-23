package edu.step.employeeManager.service.DTOservice;

import edu.step.employeeManager.dto.AddressDTO;
import edu.step.employeeManager.dto.EmployeeDTO;
import edu.step.employeeManager.exceptions.CriteriaNotMatchingException;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Address;
import edu.step.employeeManager.model.Employee;
import edu.step.employeeManager.service.DAO.CompanyDao;
import edu.step.employeeManager.service.DAO.DepartmentDao;
import edu.step.employeeManager.service.DAO.EmployeeDao;
import edu.step.employeeManager.service.DAO.ProfessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDTOService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private ProfessionDao professionDao;

    public List<EmployeeDTO> getAll() {
        List<Employee> employees = employeeDao.read();
        return employees.stream()
                .map(e -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO(e.getId(), e.getFirstName(), e.getLastName(), e.getIdnp(), e.getPhoneNumber(), e.getEmail(), e.getBirthdate(), e.getDepartment() != null ? e.getDepartment().getId() : null, e.getCompany() != null ? e.getCompany().getId() : null, new AddressDTO(), e.getProfession() != null ? e.getProfession().getId() : null);
                    if(e.getAddress() != null){
                        AddressDTO addressDTO = new AddressDTO();
                        addressDTO.setCity(e.getAddress().getCity());
                        addressDTO.setStreetName(e.getAddress().getStreetName());
                        addressDTO.setStreetNumber(e.getAddress().getStreetNumber());
                        addressDTO.setHouseNumber(e.getAddress().getHouseNumber());
                        addressDTO.setApartmentNumber(e.getAddress().getApartmentNumber());

                        employeeDTO.setAddress(addressDTO);
                    }
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    public void create(EmployeeDTO employeeDTO) throws EntityNotFoundException, CriteriaNotMatchingException {

                Employee employee = new Employee();

                employee.setFirstName(employeeDTO.getFirstName());
                employee.setLastName(employeeDTO.getLastName());
                employee.setBirthdate(employeeDTO.getBirthdate());
                employee.setIdnp(employeeDTO.getIdnp());
                employee.setPhoneNumber(employeeDTO.getPhoneNumber());
                employee.setEmail(employeeDTO.getEmail());
                employee.setSalary(employeeDTO.getSalary());
                employee.setHireDate(employeeDTO.getHireDate());
                employee.setDepartment(departmentDao.findById(employeeDTO.getDepartment()));
                employee.setProfession(professionDao.findById(employeeDTO.getProfession()));
                employee.setCompany(companyDao.findById(employeeDTO.getCompany()));

                Address address = new Address();
                address.setCity(employeeDTO.getAddress().getCity());
                address.setStreetName(employeeDTO.getAddress().getStreetName());
                address.setStreetNumber(employeeDTO.getAddress().getStreetNumber());
                address.setApartmentNumber(employeeDTO.getAddress().getApartmentNumber());
                address.setHouseNumber(employeeDTO.getAddress().getHouseNumber());

                employee.setAddress(address);

                employeeDao.create(employee);

    }

    public void update(EmployeeDTO employeeDTO) throws EntityNotFoundException, CriteriaNotMatchingException {
        Employee editedEmployee = new Employee();

        editedEmployee.setFirstName(employeeDTO.getFirstName());
        editedEmployee.setLastName(employeeDTO.getLastName());
        editedEmployee.setBirthdate(employeeDTO.getBirthdate());
        editedEmployee.setIdnp(employeeDTO.getIdnp());
        editedEmployee.setPhoneNumber(employeeDTO.getPhoneNumber());
        editedEmployee.setEmail(employeeDTO.getEmail());
        editedEmployee.setSalary(employeeDTO.getSalary());
        editedEmployee.setHireDate(employeeDTO.getHireDate());
        editedEmployee.setDepartment(departmentDao.findById(employeeDTO.getDepartment()));
        editedEmployee.setProfession(professionDao.findById(employeeDTO.getProfession()));
        editedEmployee.setCompany(companyDao.findById(employeeDTO.getCompany()));

        if(editedEmployee.getAddress()!= null){
            Address address = new Address();
            address.setCity(employeeDTO.getAddress().getCity());
            address.setStreetName(employeeDTO.getAddress().getStreetName());
            address.setStreetNumber(employeeDTO.getAddress().getStreetNumber());
            address.setApartmentNumber(employeeDTO.getAddress().getApartmentNumber());
            address.setHouseNumber(employeeDTO.getAddress().getHouseNumber());

            editedEmployee.setAddress(address);
        }
        employeeDao.update(editedEmployee);
    }

    public boolean delete(Integer id) throws EntityNotFoundException {
        Optional<Employee> foundEmployee = Optional.ofNullable(employeeDao.findById(id));
        if(foundEmployee.isPresent()) {
            employeeDao.delete(foundEmployee.get().getId());
            return true;
        }
        return false;
    }
}
