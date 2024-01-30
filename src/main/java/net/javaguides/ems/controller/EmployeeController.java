package net.javaguides.ems.controller;

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
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;



@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	//Build Add Employee Rest API

	

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>( savedEmployee,HttpStatus.CREATED);
		
	}
	//Build Get Employee Rest API
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id") Long EmployeeId){
		EmployeeDto employeeDto=employeeService.getEmployeeById(EmployeeId);
		return ResponseEntity.ok(employeeDto);
		
		}
	//Build Get All Employee Rest API
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
	List<EmployeeDto> employees= employeeService.getAllEmployees();
	return ResponseEntity.ok(employees);
	}
	
	//Build Update Employee Rest API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto=employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
		
	 	
	}
	//Build Delete Employee Rest API
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted successfully!");
	}
	}
