package com.nikhilmahajan.employeemanagementsystem.controllers;

import com.nikhilmahajan.employeemanagementsystem.dto.EmployeeRequest;
import com.nikhilmahajan.employeemanagementsystem.dto.EmployeeResponse;
import com.nikhilmahajan.employeemanagementsystem.entity.Employee;
import com.nikhilmahajan.employeemanagementsystem.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest request){
        log.info("Received request to create employee: {}", request);
        Employee employee = employeeService.saveEmployee(request);
        EmployeeResponse response = new EmployeeResponse(
                employee.getName(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getDepartment().getName()
        );
        log.debug("Created employee details: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        log.info("Fetching all employees");
        List<EmployeeResponse> employees = employeeService.getAllEmployees();
        log.debug("Total employees fetched: {}", employees.size());
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Long id){
        log.info("Fetching employee with id: {}", id);
        Employee employee = employeeService.getEmployeeById(id);
        EmployeeResponse response = new EmployeeResponse(
                employee.getName(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getDepartment().getName()
        );
        log.debug("Fetched employee details: {}", response);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long id,
                                                           @RequestBody EmployeeRequest request){
        log.info("Updating employee with id: {} | New details: {}", id, request);
        Employee employee = employeeService.updateEmployee(id, request);
        EmployeeResponse response = new EmployeeResponse(
                employee.getName(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getDepartment().getName()
        );
        log.debug("Updated employee details: {}", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        log.warn("Deleting employee with id: {}", id);
        employeeService.deleteEmployee(id);
        log.info("Employee with id {} deleted successfully", id);
        return ResponseEntity.ok("Employee Deleted Successfully..");
    }
}
