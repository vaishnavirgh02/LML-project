package com.example.EmployeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagement.entities.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>{

}
