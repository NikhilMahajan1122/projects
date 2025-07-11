package com.nikhilmahajan.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(nullable = false, unique = true)
private String name;


private String description;

@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
private List<Employee> employees;
}
