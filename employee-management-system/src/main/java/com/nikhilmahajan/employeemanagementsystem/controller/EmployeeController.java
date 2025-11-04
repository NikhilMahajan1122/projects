package com.nikhilmahajan.employeemanagementsystem.controller;

import com.nikhilmahajan.employeemanagementsystem.dto.EmployeeDto;
import com.nikhilmahajan.employeemanagementsystem.mapper.EmployeeMapper;
import com.nikhilmahajan.employeemanagementsystem.modal.Employee;
import com.nikhilmahajan.employeemanagementsystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees().stream().map(EmployeeMapper::employeeToDto).toList();
        return ResponseEntity.ok(employeeDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
            EmployeeDto employeeDto = EmployeeMapper.employeeToDto(employeeService.getEmployeeById(id));
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        Employee employee = employeeService.saveEmployee(EmployeeMapper.dtoToEmployee(employeeDto));
        EmployeeDto dto = EmployeeMapper.employeeToDto(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable Long id){
        Employee employee = employeeService.updateEmployee(EmployeeMapper.dtoToEmployee(employeeDto), id);
        EmployeeDto dto = EmployeeMapper.employeeToDto(employee);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee Deleted Successfully for id: "+id);
    }
}
