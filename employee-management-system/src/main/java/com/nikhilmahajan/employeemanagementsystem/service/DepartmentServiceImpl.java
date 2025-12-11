package com.nikhilmahajan.employeemanagementsystem.service;

import com.nikhilmahajan.employeemanagementsystem.dao.DepartmentRepository;
import com.nikhilmahajan.employeemanagementsystem.modal.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                            .orElseThrow(() -> new NoSuchElementException("Department not found for id: "+id));
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department dept, Long id) {
        Department department = getDepartmentById(id);
        department.setName(dept.getName());
        department.setDescription(dept.getDescription());

        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
       departmentRepository.deleteById(id);
    }
}
