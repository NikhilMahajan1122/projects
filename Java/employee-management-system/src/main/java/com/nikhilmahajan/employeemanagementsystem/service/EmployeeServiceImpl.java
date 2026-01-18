package com.nikhilmahajan.employeemanagementsystem.service;

import com.nikhilmahajan.employeemanagementsystem.dao.DepartmentRepository;
import com.nikhilmahajan.employeemanagementsystem.dao.EmployeeRepository;
import com.nikhilmahajan.employeemanagementsystem.modal.Department;
import com.nikhilmahajan.employeemanagementsystem.modal.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository){
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + id));
    }

    @Override
    public Employee saveEmployee(Employee emp) {
        Department dept = departmentRepository
                .findByName(emp.getDepartment().getName())
                .orElseThrow(() -> new NoSuchElementException("Department not found"));
        emp.setDepartment(dept);
        return employeeRepository.save(emp);
    }


    @Override
    public Employee updateEmployee(Employee emp, Long id) {
       Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + id));
        existingEmployee.setName(emp.getName());
        existingEmployee.setEmail(emp.getEmail());
        existingEmployee.setSalary(emp.getSalary());

        Department dept = departmentRepository
                .findByName(emp.getDepartment().getName())
                .orElseThrow(() -> new NoSuchElementException("Department not found"));
        existingEmployee.setDepartment(dept);
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
