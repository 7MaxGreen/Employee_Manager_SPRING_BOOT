package edu.step.employeeManager.controller;

import edu.step.employeeManager.dto.DepartmentDTO;
import edu.step.employeeManager.exceptions.EntityNotFoundException;

import edu.step.employeeManager.service.DTOservice.DepartmentDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentDTOService dtoService;


    @GetMapping
    public List<DepartmentDTO> getAll(){
        return dtoService.getAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody DepartmentDTO departmentDTO){
        dtoService.create(departmentDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody DepartmentDTO departmentDTO) {
        try{
            dtoService.update(departmentDTO);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        boolean result = dtoService.delete(id);
        if(result){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
