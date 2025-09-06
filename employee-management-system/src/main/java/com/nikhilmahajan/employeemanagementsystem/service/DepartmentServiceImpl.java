package com.nikhilmahajan.employeemanagementsystem.service;

import com.nikhilmahajan.employeemanagementsystem.dto.DepartmentRequest;
import com.nikhilmahajan.employeemanagementsystem.dto.DepartmentResponse;
import com.nikhilmahajan.employeemanagementsystem.entity.Department;
import com.nikhilmahajan.employeemanagementsystem.entity.Employee;
import com.nikhilmahajan.employeemanagementsystem.repository.DepartmentRepository;
import com.nikhilmahajan.employeemanagementsystem.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService
{

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentResponse saveDepartment(DepartmentRequest request) {
        Department department= new Department();
        department.setName(request.getName());
        department.setDescription(request.getDescription());
        Department savedDepartment = departmentRepository.save(department);
        return new DepartmentResponse(savedDepartment.getName(),savedDepartment.getDescription(),
                savedDepartment.getEmployees() != null ? savedDepartment.getEmployees().stream().map(Employee::getName).toList():List.of());
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(dept -> new DepartmentResponse(dept.getName(), dept.getDescription(),
                dept.getEmployees() != null ? dept.getEmployees().stream().map(Employee::getName).toList():List.of())).toList();
    }

    @Override
    public DepartmentResponse getDepartmentsById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Department not found with id: " + id));
        return new DepartmentResponse(department.getName(), department.getDescription(),
                department.getEmployees() != null ?  department.getEmployees().stream().map(Employee::getName).toList():List.of());
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentRequest request) {
        Department department = departmentRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Department not found with id: " + id));
        department.setName(request.getName());
        department.setDescription(request.getDescription());
        Department updatedDepartment = departmentRepository.save(department);
        return new DepartmentResponse(updatedDepartment.getName(),updatedDepartment.getDescription(),
                updatedDepartment.getEmployees() != null ? updatedDepartment.getEmployees().stream().map(Employee::getName).toList():List.of());
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
