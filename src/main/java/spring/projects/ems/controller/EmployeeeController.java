package spring.projects.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.projects.ems.dto.EmployeeDto;
import spring.projects.ems.entity.Employee;
import spring.projects.ems.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeeController {
	
	private EmployeeService employeeService;

	public EmployeeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
		
	}
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
		
	}
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> UpdateEmployeeById(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedemployee){
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedemployee);
		return ResponseEntity.ok(employeeDto);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Void> DeletebyId(@PathVariable("id") Long employeeId) {
		employeeService.DeleteEmployee(employeeId);
		return ResponseEntity.noContent().build();
	}
	

}
