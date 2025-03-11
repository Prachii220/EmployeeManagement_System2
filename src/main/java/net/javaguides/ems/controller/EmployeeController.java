package net.javaguides.ems.controller;


import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build add employee Rest APi;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee =employeeService.createEmployeeDto(employeeDto );
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build get employee Rest APi
    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
       EmployeeDto employeeDto=  employeeService.getEmployeeById(employeeId);
       return  ResponseEntity.ok(employeeDto);
    }

    //Build get ALL employee REst apis
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return  ResponseEntity.ok(employees);
    }

    //build update employee REST APIs
    @PutMapping("{id}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("{id}") Long employeeId,
                                                       @RequestBody EmployeeDto updatedEmployee){

       EmployeeDto employeeDto= employeeService.updateEmployee(employeeId, updatedEmployee);
       return  ResponseEntity.ok(employeeDto);

    }

    //Build delete employee REST APis
    @DeleteMapping
    public  ResponseEntity<String> deleteEmployee(Long employeeId){
    employeeService.deleteEmployee(employeeId);
    return ResponseEntity.ok("Employee Successfully deleted");


}}
