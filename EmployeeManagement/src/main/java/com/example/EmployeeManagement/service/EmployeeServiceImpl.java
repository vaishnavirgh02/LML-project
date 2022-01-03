package com.example.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagement.dao.EmployeeDao;
import com.example.EmployeeManagement.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	EmployeeDao employeedao;
	
	@Override
	public Employee addEmployee(Employee emp) {
		return employeedao.save(emp);
	}

	@Override
	public List<Employee> showEmployees() {
		return employeedao.findAll();
	}

	@Override
	public Employee searchById(Integer id) {
		return employeedao.getById(id);
	}

	@Override
	public void delete(Employee emp)
	{
		employeedao.delete(emp);
	}

}
