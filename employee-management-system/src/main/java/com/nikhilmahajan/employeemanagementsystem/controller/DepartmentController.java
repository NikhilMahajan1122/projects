package com.nikhilmahajan.employeemanagementsystem.controller;

import com.nikhilmahajan.employeemanagementsystem.dto.DepartmentDto;
import com.nikhilmahajan.employeemanagementsystem.mapper.DepartmentMapper;
import com.nikhilmahajan.employeemanagementsystem.modal.Department;
import com.nikhilmahajan.employeemanagementsystem.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> departmentDtoList = departmentService.getAllDepartments().stream()
                                            .map(DepartmentMapper::departmentToDto).toList();
        return ResponseEntity.ok(departmentDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id){
        DepartmentDto departmentDto = DepartmentMapper.departmentToDto(departmentService.getDepartmentById(id));
        return ResponseEntity.ok(departmentDto);
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto){
       Department department = departmentService.saveDepartment(DepartmentMapper.dtoToDepartment(departmentDto));
       DepartmentDto dto = DepartmentMapper.departmentToDto(department);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto,@PathVariable Long id){
        Department department = departmentService.updateDepartment(DepartmentMapper.dtoToDepartment(departmentDto),id);
        DepartmentDto dto = DepartmentMapper.departmentToDto(department);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);

        return ResponseEntity.ok("Department Deleted Successfully..");
    }




}
