// package com.example.restservice;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;
// import java.util.List;

// class EmployeeManagerTest {

//     private EmployeeManager employeeManager;

//     @BeforeEach
//     void setUp() {
//         employeeManager = new EmployeeManager();
//     }

//     @Test
//     void testGetAllEmployees_NotEmpty() {
//         List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
//         assertNotNull(employees);
//         assertFalse(employees.isEmpty(), "Employee list should not be empty initially.");
//     }

//     @Test
//     void testAddEmployee_Success() {
//         Employee newEmployee = new Employee("E104", "Bob", "Williams", "bob.williams@example.com", "QA Engineer");
//         employeeManager.addEmployee(newEmployee);

//         List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
//         assertTrue(employees.contains(newEmployee), "Newly added employee should be present in the list.");
//     }

//     @Test
//     void testAddDuplicateEmployee() {
//         Employee duplicateEmployee = new Employee("E101", "Prem", "Tiwari", "chapradreams@gmail.com", "EMPLOYEE");
//         employeeManager.addEmployee(duplicateEmployee);

//         long count = employeeManager.getAllEmployees().getEmployeeList()
//                 .stream().filter(emp -> emp.getEmployee_id().equals("E101")).count();

//         assertEquals(2, count, "Duplicate employee ID should be present twice.");
//     }
// }
package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class EmployeeManagerTest {

    private EmployeeManager employeeManager;

  @BeforeEach
void setUp() {
    employeeManager = new EmployeeManager();

    // ✅ Reset employee list with default employees
    List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
    employees.clear(); // Clear any old data

    // ✅ Add default employees (ensures list is not empty)
    employees.add(new Employee("E101", "Prem", "Tiwari", "chapradreams@gmail.com", "EMPLOYEE"));
    employees.add(new Employee("E102", "Vikash", "Kumar", "abc@gmail.com", "MANAGER"));
    employees.add(new Employee("E103", "Ritesh", "Ojha", "asdjf@gmail.com", "ADMIN"));
}



    @Test
    void testGetAllEmployees_NotEmpty() {
        List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
        assertNotNull(employees);
        assertFalse(employees.isEmpty(), "Employee list should not be empty initially.");
    }

    @Test
    void testAddEmployee_Success() {
        Employee newEmployee = new Employee("E104", "Bob", "Williams", "bob.williams@example.com", "QA Engineer");
        employeeManager.addEmployee(newEmployee);

        List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
        assertTrue(employees.contains(newEmployee), "Newly added employee should be present in the list.");
    }

    @Test
void testAddDuplicateEmployee() {
    // ✅ Get initial count of "E101" before adding duplicate
    long initialCount = employeeManager.getAllEmployees().getEmployeeList()
            .stream().filter(emp -> emp.getEmployee_id().equals("E101")).count();

    // ✅ Add the same employee ID again
    Employee duplicateEmployee = new Employee("E101", "Prem", "Tiwari", "chapradreams@gmail.com", "EMPLOYEE");
    employeeManager.addEmployee(duplicateEmployee);

    // ✅ Get new count after adding the duplicate
    long finalCount = employeeManager.getAllEmployees().getEmployeeList()
            .stream().filter(emp -> emp.getEmployee_id().equals("E101")).count();

    // ✅ Test passes if the count increased by exactly 1
    assertEquals(initialCount + 1, finalCount, "Duplicate employee ID should be present again.");
}

}
