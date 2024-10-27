package spring.projects.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import spring.projects.ems.dto.EmployeeDto;
import spring.projects.ems.entity.Employee;
import spring.projects.ems.exception.RecourseNotFoundException;
import spring.projects.ems.mapper.EmployeeMapper;
import spring.projects.ems.repository.EmployeeRepository;
import spring.projects.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()->
					new RecourseNotFoundException("Employee Id not exits"+ employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee>  employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
		
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				()-> new RecourseNotFoundException("Employee not exits :"+employeeId));
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatesEmployeeObj = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updatesEmployeeObj);
	}

	@Override
	public void DeleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				()-> new RecourseNotFoundException("Employee not exits :"+employeeId));
		employeeRepository.deleteById(employeeId);
		
	}
	

}
