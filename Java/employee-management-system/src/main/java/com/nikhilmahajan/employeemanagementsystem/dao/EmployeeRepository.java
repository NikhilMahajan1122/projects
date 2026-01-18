package com.nikhilmahajan.employeemanagementsystem.dao;

import com.nikhilmahajan.employeemanagementsystem.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findByDepartmentId(Long departmentId);
}
