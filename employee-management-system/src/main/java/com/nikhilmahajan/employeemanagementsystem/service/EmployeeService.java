package com.nikhilmahajan.employeemanagementsystem.service;

import com.nikhilmahajan.employeemanagementsystem.modal.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long id);
    public Employee saveEmployee(Employee employee);
    public Employee updateEmployee(Employee employee, Long id);
    public void deleteEmployee(Long id);

}
