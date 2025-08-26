package com.nikhilmahajan.employeemanagementsystem.service;

import com.nikhilmahajan.employeemanagementsystem.dto.EmployeeRequest;
import com.nikhilmahajan.employeemanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(EmployeeRequest request);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}
