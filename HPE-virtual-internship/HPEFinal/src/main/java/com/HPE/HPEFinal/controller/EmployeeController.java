package com.HPE.HPEFinal.controller;

import com.HPE.HPEFinal.model.Employee;
import com.HPE.HPEFinal.servicerepo.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    // HTTP GET request to retrieve all user data
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeManager.getEmployees();
    }

    // HTTP POST request to add an employee
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        // Assuming EmployeeManager has a method to add an employee
        Employee isAdded = employeeManager.addEmployee(employee);

            return new ResponseEntity<>(isAdded, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public Employee updateEmp(@PathVariable String id,@RequestBody Employee employee){

        Employee x = employeeManager.findEmp(id,employee);
        return employeeManager.saveEmp(employee,x);
    }
}