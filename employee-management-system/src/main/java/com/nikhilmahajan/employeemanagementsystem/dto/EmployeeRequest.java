package com.nikhilmahajan.employeemanagementsystem.dto;

import lombok.Data;

@Data
public class EmployeeRequest {

    private String name;
    private String email;
    private double salary;
    private Long departmentId;

}
