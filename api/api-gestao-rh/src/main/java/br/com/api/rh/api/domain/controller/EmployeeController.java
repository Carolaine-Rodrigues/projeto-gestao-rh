package br.com.api.rh.api.domain.controller;

import br.com.api.rh.api.domain.dto.EmployeeRequestDTO;
import br.com.api.rh.api.domain.entity.Employee;
import br.com.api.rh.api.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping("/save")
    public ResponseEntity saveEmployees(@RequestBody EmployeeRequestDTO data){
        var employeeData = service.saveEmployees(data);
        return ResponseEntity.ok().body(employeeData);
    }

    @PutMapping(value= "/update/{id}")
    public ResponseEntity updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO updateData){
            var updateEmployee = service.updateEmployees(id,updateData);
            return ResponseEntity.ok().body(updateEmployee);
    }

    @GetMapping(value= "/")
    public ResponseEntity<List<Employee>> listAll(){
        List<Employee> list = service.listAllEmployees();
        return ResponseEntity.ok(list);
    }
    @GetMapping(value= "/{id}/")
    public ResponseEntity<Employee> listId(@PathVariable Long id){
            var listEmployee = service.listEmployeeId(id);
            return ResponseEntity.ok().body(listEmployee);
    }

    @DeleteMapping(value= "/delete/{id}/")
    public ResponseEntity deleteId(@PathVariable Long id){
            service.deleteId(id);
            return ResponseEntity.noContent().build();
    }
}

