package com.nikhilmahajan.employeemanagementsystem.controllers;

import com.nikhilmahajan.employeemanagementsystem.dto.EmployeeRequest;
import com.nikhilmahajan.employeemanagementsystem.dto.EmployeeResponse;
import com.nikhilmahajan.employeemanagementsystem.entity.Employee;
import com.nikhilmahajan.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest request){
            Employee employee = employeeService.saveEmployee(request);
        return ResponseEntity.ok(new EmployeeResponse(employee.getName(), employee.getEmail(),
                employee.getSalary(), employee.getDepartment().getName()));
    }


    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(new EmployeeResponse(employee.getName(), employee.getEmail(),
                employee.getSalary(), employee.getDepartment().getName()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest request){
        Employee employee = employeeService.updateEmployee(id, request);
        return ResponseEntity.ok(new EmployeeResponse(employee.getName(), employee.getEmail(),
                employee.getSalary(), employee.getDepartment().getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee Deleted Successfully..");
    }
}
