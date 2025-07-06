package com.examly.service;

import java.math.BigDecimal;
import java.util.List;

import com.examly.entity.Employee;

public interface EmployeeService 
{
    String addEmployee(Employee employee);
    String updateEmployee(Employee employee);
    String deleteEmployee(int empId);
    List<Employee>getAllEmployees();
    List<Employee>searchByDesignation(String designation);
    List<Employee>filterByDepartment(String department);
    List<Employee>filterBySalaryRange(BigDecimal salary);
}
