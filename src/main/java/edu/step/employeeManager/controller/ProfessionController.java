package edu.step.employeeManager.controller;

import edu.step.employeeManager.dto.DepartmentDTO;
import edu.step.employeeManager.dto.ProfessionDTO;
import edu.step.employeeManager.exceptions.CriteriaNotMatchingException;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.service.DTOservice.ProfessionDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professions")
public class ProfessionController {

    @Autowired
    private ProfessionDTOService dtoService;

    @GetMapping
    public List<ProfessionDTO> getAll() {return dtoService.getAll(); }

    @PostMapping("/create")
    public void create(@RequestBody ProfessionDTO professionDTO) throws CriteriaNotMatchingException, EntityNotFoundException {
        dtoService.create(professionDTO);
    }
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody ProfessionDTO professionDTO) {
        try{
            dtoService.update(professionDTO);
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
