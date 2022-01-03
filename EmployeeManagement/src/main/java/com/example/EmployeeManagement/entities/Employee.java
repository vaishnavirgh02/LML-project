package com.example.EmployeeManagement.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Integer empId;
	
	@NotNull
	@Size(min = 2, max = 30)
	@Column(name = "emp_name")
	private String empName;
	
	@NotNull
	@Column(name = "emp_salary")
	private Double empSalary;

	public Employee() {
		
	}

	public Employee( String empName, Double empSalary) {
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

}
