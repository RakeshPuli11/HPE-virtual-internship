package com.HPE.HPEFinal.servicerepo;

import com.HPE.HPEFinal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeManager{
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

    public Employee addEmployee(Employee employee) {
        l.add(employee);
        System.out.println(employee);
        return  employee;
    }


    public Employee findEmp(String id, Employee employee) {
        Employee x = new Employee();
        for (Employee e: l){
            if(e.getEmployee_id().equals(id)){
                x= e;
                break;
            }
        }
        return x;
    }

    public Employee saveEmp(Employee employee, Employee x) {
        x.setEmployee_id(employee.getEmployee_id());
        x.setFirst_name(employee.getFirst_name());
        x.setLast_name(employee.getLast_name());
        x.setMail(employee.getMail());
        x.setTitle(employee.getTitle());
        return x;
    }
}

