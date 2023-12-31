package com.HPE.Task3.controller;

import com.HPE.Task3.model.Employee;
import com.HPE.Task3.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    // HTTP POST request to add an employee
    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        // Assuming EmployeeManager has a method to add an employee
        boolean isAdded = employeeManager.addEmployee(employee);

        if (isAdded) {
            return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}