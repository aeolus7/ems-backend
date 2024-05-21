package com.projectjee.emsbackend.controller;

import com.projectjee.emsbackend.dto.employeedto;
import com.projectjee.emsbackend.service.EmployeeService;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/employees")
public class employeeController {
    @Autowired
    private EmployeeService employeeService;
    //build add employee rest api
    @PostMapping

    public ResponseEntity<employeedto> createEmployee( @RequestBody employeedto employeedto){
        employeedto savedEmployee=employeeService.createEmployee(employeedto);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<employeedto> getEmployeeById(@PathVariable("id") Long employeeId){
        employeedto employeedto=employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeedto);
    }
    //build get all employeees rest api
    @GetMapping
    public ResponseEntity<List<employeedto>> getAllEmployees(){
        List<employeedto> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    //build update emp rest api
    @PutMapping("{id}")
    public ResponseEntity<employeedto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody employeedto updatedemployee){
       employeedto employeedto = employeeService.updateEmployee(employeeId,updatedemployee);
       return ResponseEntity.ok(employeedto);

    }
    //build delete employee rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("employee deleted");
    }
}
