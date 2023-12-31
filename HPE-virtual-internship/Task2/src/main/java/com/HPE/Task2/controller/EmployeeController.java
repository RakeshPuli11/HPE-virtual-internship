package com.HPE.Task2.controller;

import com.HPE.Task2.entity.Employee;
import com.HPE.Task2.repo.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
   @Autowired
    private EmployeeManager employeeManager;

//    public EmployeeController(EmployeeManager employeeManager) {
//        this.employeeManager = employeeManager;
//    }

    // HTTP GET request to retrieve all user data
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeManager.getEmployees();
    }
}
