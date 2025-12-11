package com.nikhilmahajan.employeemanagementsystem.mapper;

import com.nikhilmahajan.employeemanagementsystem.dto.EmployeeDto;
import com.nikhilmahajan.employeemanagementsystem.modal.Department;
import com.nikhilmahajan.employeemanagementsystem.modal.Employee;

public final class EmployeeMapper {

private EmployeeMapper(){}

    public static Employee dtoToEmployee(EmployeeDto dto){
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setSalary(dto.getSalary());

        Department dept = new Department();
        dept.setName(dto.getDeptName());
        emp.setDepartment(dept);
        return emp;
    }

    public static EmployeeDto employeeToDto(Employee emp){
       String deptName = null;
       if(emp.getDepartment() != null){
           deptName = emp.getDepartment().getName();
       }
        return new EmployeeDto(emp.getName(), emp.getEmail(), emp.getSalary(),deptName);
    }

}
