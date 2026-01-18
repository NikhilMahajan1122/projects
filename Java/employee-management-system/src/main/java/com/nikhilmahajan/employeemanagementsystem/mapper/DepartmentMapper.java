package com.nikhilmahajan.employeemanagementsystem.mapper;

import com.nikhilmahajan.employeemanagementsystem.dto.DepartmentDto;
import com.nikhilmahajan.employeemanagementsystem.modal.Department;

public final class DepartmentMapper {

    private DepartmentMapper(){}

    public static Department dtoToDepartment(DepartmentDto dto){
        Department dept = new Department();
        dept.setName(dto.getName());
        dept.setDescription(dto.getDescription());
        return dept;
    }

    public static DepartmentDto departmentToDto(Department dept){
        return new DepartmentDto(dept.getName(), dept.getDescription());
    }
}
