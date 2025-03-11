package net.javaguides.ems.services;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.mapper.EmployeeMapper;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployeeDto(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
    
    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee );

    void deleteEmployee(Long employeeId);

}
