package com.example.EmployeeManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagement.entities.Employee;

@Service
public interface IEmployeeService {

	Employee addEmployee(Employee employee);
	List<Employee> showEmployees();
	Employee searchById(Integer id);
	void delete(Employee emp);
}
