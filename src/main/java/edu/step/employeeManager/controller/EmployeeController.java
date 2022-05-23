package edu.step.employeeManager.controller;

import edu.step.employeeManager.dto.EmployeeDTO;
import edu.step.employeeManager.exceptions.CriteriaNotMatchingException;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.service.DTOservice.EmployeeDTOService;
import edu.step.employeeManager.service.DAO.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDTOService dtoService;

    @GetMapping
    public List<EmployeeDTO> getAll(){
        return dtoService.getAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody EmployeeDTO emp) throws CriteriaNotMatchingException, EntityNotFoundException {
        dtoService.create(emp);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody EmployeeDTO emp) {
       try{
           dtoService.update(emp);
           return ResponseEntity.ok().build();
       } catch (EntityNotFoundException | CriteriaNotMatchingException ex) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
       }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) throws EntityNotFoundException {
        boolean result = dtoService.delete(id);
        if(result){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
