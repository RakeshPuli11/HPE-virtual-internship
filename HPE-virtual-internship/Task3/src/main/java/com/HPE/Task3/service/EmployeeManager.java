package com.HPE.Task3.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.HPE.Task3.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeManager {
    List<Employee> l =  new ArrayList<>();

    public EmployeeManager() {
        // Initialize Employees class with example employees
        Employee employee1 = new Employee("1", "John", "Doe", "john.doe@example.com", "Developer");
        Employee employee2 = new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Manager");
        Employee employee3 = new Employee("3", "Bob", "Johnson", "bob.johnson@example.com", "Designer");

        l.add(employee1);
        l.add(employee2);
        l.add(employee3);
    }

    // Getter for Employees
    public List<Employee> getEmployees() {
        return l;
    }

    public boolean addEmployee(Employee employee) {
        l.add(employee);
        System.out.println(employee);
        return  true;
    }
}

