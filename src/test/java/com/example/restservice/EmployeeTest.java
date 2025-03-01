// package com.example.restservice;

// import org.junit.jupiter.api.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// class EmployeeTest {

//     @Autowired
//     private EmployeeManager employeeManager;

//     @BeforeEach
//     @Order(1)
//     void setUp() {
//         employeeManager.getAllEmployees().getEmployeeList().clear();
//     }

//     @Test
//     @Order(2)
//     void testInitialNumberOfEmployees() {
//         assertEquals(0, employeeManager.getAllEmployees().getEmployeeList().size());
//     }

//     @Test
//     @Order(3)
//     void testAddEmployee() {
//         Employee newEmployee = new Employee(1, "John", "Doe", "john@example.com", "EMPLOYEE");
//         employeeManager.addEmployee(newEmployee);
//         assertEquals(1, employeeManager.getAllEmployees().getEmployeeList().size());
//         assertTrue(employeeManager.getAllEmployees().getEmployeeList().contains(newEmployee));
//     }

//     @Test
//     @Order(4)
//     void testGetAllEmployees() {
//         Employee employee1 = new Employee(1, "John", "Doe", "john@example.com", "EMPLOYEE");
//         Employee employee2 = new Employee(1, "John", "Doe", "john@example.com", "EMPLOYEE");
//         employeeManager.addEmployee(employee1);
//         employeeManager.addEmployee(employee2);
//         Employees employees = employeeManager.getAllEmployees();
//         assertNotNull(employees);
//         assertNotNull(employees.getEmployeeList());
//         assertEquals(2, employees.getEmployeeList().size());
//     }
// }


package com.example.restservice;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeTest {

    @Autowired
    private EmployeeManager employeeManager;

    @BeforeEach
    @Order(1)
    void setUp() {
        employeeManager.getAllEmployees().getEmployeeList().clear();
    }

    @Test
    @Order(2)
    void testInitialNumberOfEmployees() {
        assertEquals(0, employeeManager.getAllEmployees().getEmployeeList().size());
    }

    @Test
    @Order(3)
    void testAddEmployee() {
        // ✅ Changed employee_id from int (1) to String ("E101")
        Employee newEmployee = new Employee("E101", "John", "Doe", "john@example.com", "EMPLOYEE");
        employeeManager.addEmployee(newEmployee);
        assertEquals(1, employeeManager.getAllEmployees().getEmployeeList().size());
        assertTrue(employeeManager.getAllEmployees().getEmployeeList().contains(newEmployee));
    }

    @Test
    @Order(4)
    void testGetAllEmployees() {
        // ✅ Changed employee_id from int (1) to String ("E101" and "E102")
        Employee employee1 = new Employee("E101", "John", "Doe", "john@example.com", "EMPLOYEE");
        Employee employee2 = new Employee("E102", "Jane", "Doe", "jane@example.com", "MANAGER");
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        Employees employees = employeeManager.getAllEmployees();
        assertNotNull(employees);
        assertNotNull(employees.getEmployeeList());
        assertEquals(2, employees.getEmployeeList().size());
    }
}
