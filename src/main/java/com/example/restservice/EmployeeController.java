package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;
    @GetMapping("/employees")
    public Employees employees(){
        return employeeManager.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employees employees(@RequestBody Employee employee){
        employeeManager.addEmployee(employee);
        return employeeManager.getAllEmployees();
    }
}
