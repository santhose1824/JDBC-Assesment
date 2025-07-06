package com.examly.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Employee 
{
    private int employeeId;
    private String employeeName;
    private String designation;
    private String department;
    private BigDecimal salary;
    private Date dateOfJoin;

    public Employee(int employeeId, String employeeName, String designation, String department, BigDecimal salary,Date dateOfJoin) 
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
        this.dateOfJoin = dateOfJoin;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    @Override
    public String toString() {
        return String.format(
        "%-15s : %s\n%-15s : %s\n%-15s : %s\n%-15s : %d\n%-15s : %.2f\n%-15s : %s",
        "Employee Id",employeeId,
        "Employee Name",employeeName,
        "Designation",designation,
        "Department",department,
        "Salary",salary,
        "Date of Join",dateOfJoin
        );
    }

    
    
}
