package com.example.EmployeeManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.EmployeeManagement.dto.EmployeeDTO;
import com.example.EmployeeManagement.entities.Employee;
import com.example.EmployeeManagement.service.EmployeeServiceImpl;
@RestController
@EnableTransactionManagement
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceimpl;
	
	@PostMapping("/add")
	public EmployeeDTO addEmployee(@RequestBody Employee emp) {
		Employee emp1=employeeServiceimpl.addEmployee(emp);
		EmployeeDTO i = new EmployeeDTO(emp1);
        return i;
    }
	
	@GetMapping(value = "/find/{id}")
    public List<EmployeeDTO> findEmployeeById(@PathVariable("id")int id) {
		Employee emp = employeeServiceimpl.searchById(id);
		List<EmployeeDTO> l = new ArrayList<EmployeeDTO>();
		EmployeeDTO i = new EmployeeDTO(emp);
		l.add(i);
        return l;
    }
    
    
    @GetMapping("/find-all/")
    public ResponseEntity<List<Employee>> showEmployees(){
        List<Employee> employeeList = employeeServiceimpl.showEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
    
	
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<Employee> deleteEmployee(@RequestBody Employee emp){
		
		employeeServiceimpl.delete(emp);
		
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	

}
