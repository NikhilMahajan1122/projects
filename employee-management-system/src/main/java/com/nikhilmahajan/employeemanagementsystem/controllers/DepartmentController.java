package com.nikhilmahajan.employeemanagementsystem.controllers;

import com.nikhilmahajan.employeemanagementsystem.dto.DepartmentRequest;
import com.nikhilmahajan.employeemanagementsystem.dto.DepartmentResponse;
import com.nikhilmahajan.employeemanagementsystem.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponse> saveDepartment(@RequestBody DepartmentRequest request){
        log.info("Received request to save department: {}", request);
        DepartmentResponse response = departmentService.saveDepartment(request);
        log.debug("Saved department details: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments(){
        log.info("Fetching all departments");
        List<DepartmentResponse> departments = departmentService.getAllDepartments();
        log.debug("Total departments fetched: {}", departments.size());
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartment(@PathVariable Long id){
        log.info("Fetching department with id: {}", id);
        DepartmentResponse response = departmentService.getDepartmentsById(id);
        log.debug("Fetched department details: {}", response);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@PathVariable Long id,
                                                               @RequestBody DepartmentRequest request){
        log.info("Updating department with id: {} | New details: {}", id, request);
        DepartmentResponse response = departmentService.updateDepartment(id, request);
        log.debug("Updated department details: {}", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        log.warn("Deleting department with id: {}", id);
        departmentService.deleteDepartment(id);
        log.info("Department with id {} deleted successfully", id);
        return ResponseEntity.ok("Department Deleted Successfully...");
    }
}
