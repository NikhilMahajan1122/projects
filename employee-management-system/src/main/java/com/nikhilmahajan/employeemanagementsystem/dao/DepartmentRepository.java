package com.nikhilmahajan.employeemanagementsystem.dao;

import com.nikhilmahajan.employeemanagementsystem.modal.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Optional<Department> findByName(String name);
}
