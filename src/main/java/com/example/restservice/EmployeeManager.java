package com.example.restservice;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {

    private static Employees list = new Employees();

    static {
        list.getEmployeeList().add(
                new Employee("1", "Prem", "Tiwari", "chapradreams@gmail.com", "EMPLOYEE"));

        list.getEmployeeList().add(
                new Employee("2", "Vikash", "Kumar", "abc@gmail.com", "MANAGER"));

        list.getEmployeeList().add(
                new Employee("3", "Ritesh", "Ojha", "asdjf@gmail.com", "ADMIN"));

    }

    public Employees getAllEmployees() {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }

}
