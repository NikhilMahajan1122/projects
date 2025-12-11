package com.nikhilmahajan.employeemanagementsystem.service;


import com.nikhilmahajan.employeemanagementsystem.modal.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    public List<Department> getAllDepartments();
    public Department getDepartmentById(Long id);
    public Department saveDepartment(Department department);
    public Department updateDepartment(Department department, Long id);
    public void deleteDepartment(Long id);

}
