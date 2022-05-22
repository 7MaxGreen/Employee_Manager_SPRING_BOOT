package edu.step.employeeManager.controller;

import edu.step.employeeManager.dto.CompanyDTO;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Company;
import edu.step.employeeManager.repository.CompanyRepository;
import edu.step.employeeManager.service.DTOservice.CompanyDTOService;
import edu.step.employeeManager.service.DAO.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyDTOService dtoService;


    @GetMapping
    public List<CompanyDTO> getAll(){
        return dtoService.getAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody CompanyDTO company){
        dtoService.create(company);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody CompanyDTO company) {
        try{
            dtoService.update(company);
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

//    @GetMapping("/filtered")
//    public List<CompanyDTO> getAllFiltered(){
//
//        repository.findByNameLike("Goo%");
//        return new ArrayList<>();
//    }

}
