package com.example.EmployeeManagement.dto;

import java.io.Serializable;

import com.example.EmployeeManagement.entities.Employee;

public class EmployeeDTO implements Serializable {
    public static final long serialVersionUID = 1L; 
    
    private Integer empId;
    private String empName;
    private Double empSalary;

    public EmployeeDTO(){

    }

    public EmployeeDTO(Employee e){
        this.empId = e.getEmpId();
        this.empName = e.getEmpName();
        this.empSalary = e.getEmpSalary();
    }

    

    @Override
    public String toString() {
        return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
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

    
}
