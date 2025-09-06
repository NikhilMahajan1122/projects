package com.nikhilmahajan.employeemanagementsystem.service;

import com.nikhilmahajan.employeemanagementsystem.dto.EmployeeRequest;
import com.nikhilmahajan.employeemanagementsystem.dto.EmployeeResponse;
import com.nikhilmahajan.employeemanagementsystem.entity.Department;
import com.nikhilmahajan.employeemanagementsystem.entity.Employee;
import com.nikhilmahajan.employeemanagementsystem.repository.DepartmentRepository;
import com.nikhilmahajan.employeemanagementsystem.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository){
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Employee saveEmployee(EmployeeRequest request) {
        Department dept = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(()-> new RuntimeException("Department Not Found.."));
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setDepartment(dept);

        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees= employeeRepository.findAll();

        return employees.stream()
                .map(emp -> new EmployeeResponse(emp.getName(), emp.getEmail(),emp.getSalary(), emp.getDepartment().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeRequest request) {
        Employee existing = getEmployeeById(id);
        Department dept = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(()-> new RuntimeException("Department Not Found.."));
        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        existing.setSalary(request.getSalary());
        existing.setDepartment(dept);

        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
