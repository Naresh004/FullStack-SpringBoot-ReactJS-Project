package spring.projects.ems.service;

import java.util.List;

import spring.projects.ems.dto.EmployeeDto;
import spring.projects.ems.entity.Employee;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);

	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
	
	public void DeleteEmployee(Long employeeId);
	

}
