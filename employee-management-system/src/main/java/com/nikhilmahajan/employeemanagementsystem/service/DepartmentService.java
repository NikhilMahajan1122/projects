package com.nikhilmahajan.employeemanagementsystem.service;

import com.nikhilmahajan.employeemanagementsystem.dto.DepartmentRequest;
import com.nikhilmahajan.employeemanagementsystem.dto.DepartmentResponse;
import com.nikhilmahajan.employeemanagementsystem.entity.Department;

import java.util.List;

public interface DepartmentService {


    DepartmentResponse saveDepartment(DepartmentRequest request);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse getDepartmentsById(Long id);


    DepartmentResponse updateDepartment(Long id, DepartmentRequest request);

    void deleteDepartment(Long id);
}
