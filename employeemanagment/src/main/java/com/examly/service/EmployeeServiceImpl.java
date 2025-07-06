package com.examly.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examly.entity.Employee;
import com.examly.util.DBConnectionUtil;

public class EmployeeServiceImpl implements EmployeeService
{

    @Override
    public String addEmployee(Employee employee) {
        String sqlQuery = "INSERT INTO employee (emp_id,name,designation,department,salary,doj) VALUES(?,?,?,?,?,?)";
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        )
        {
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setString(3, employee.getDesignation());
            preparedStatement.setString(4, employee.getDepartment());
            preparedStatement.setBigDecimal(5, employee.getSalary());
            preparedStatement.setDate(6, employee.getDateOfJoin());

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0 ? "Employee Data added Successfully" :"Failed to add Employee Data";

        } 
        catch(SQLException e)
        {
            System.out.println("Error on inserting the data : ");
            return e.toString();
        }
        
    }

    @Override
    public String updateEmployee(Employee employee) {
         String sqlQuery = "UPDATE employee SET name = ?, designation = ?, department = ?,salary = ?,doj =? WHERE emp_id  = ?";
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        )
        {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getDesignation());
            preparedStatement.setString(3, employee.getDepartment());
            preparedStatement.setBigDecimal(4, employee.getSalary());
            preparedStatement.setDate(5, employee.getDateOfJoin());
            preparedStatement.setInt(6, employee.getEmployeeId());
            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0 ? "Employee Data updated Successfully" :"Failed to update Employee Data";

        } 
        catch(SQLException e)
        {
            System.out.println("Error on updating the data : ");
            return e.toString();
        }
    }

    @Override
    public String deleteEmployee(int empId) {
        String sqlQuery = "DELETE FROM employee WHERE emp_id = ?";
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        )
        {
            preparedStatement.setInt(1, empId);
            

            int rowsDeleted = preparedStatement.executeUpdate();

            return rowsDeleted > 0 ? "Employee Data deleted Successfully" :"Failed to delete Employee Data";

        } 
        catch(SQLException e)
        {
            System.out.println("Error on inserting the data : ");
            return e.toString();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sqlQuery = "SELECT * from employee";
        List<Employee> employeesList = new ArrayList<>();
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
        )
        {
            while (resultSet.next()) {
                employeesList.add(extractEmployeeData(resultSet));
            }
        } 
        catch(SQLException e)
        {
            System.out.println("Error on inserting the data : ");
        }
        return employeesList;
    }

    @Override
    public List<Employee> searchByDesignation(String designation) {
        String sqlQuery = "SELECT * from employee WHERE designation  = ?";
        List<Employee> employeesList = new ArrayList<>();
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        )
        {   
            preparedStatement.setString(1, designation);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeesList.add(extractEmployeeData(resultSet));
            }
        } 
        catch(SQLException e)
        {
            System.out.println("Error on fetching the data : ");
        }
        return employeesList;
    }

    @Override
    public List<Employee> filterByDepartment(String department) {
               String sqlQuery = "SELECT * from employee WHERE department  = ?";
        List<Employee> employeesList = new ArrayList<>();
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        )
        {   
            preparedStatement.setString(1, department);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeesList.add(extractEmployeeData(resultSet));
            }
        } 
        catch(SQLException e)
        {
            System.out.println("Error on fetching the data : ");
        }
        return employeesList;
    }

    @Override
    public List<Employee> filterBySalaryRange(BigDecimal salary) {
        String sqlQuery = "SELECT * from employee WHERE salary  > ?";
        List<Employee> employeesList = new ArrayList<>();
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        )
        {   
            preparedStatement.setBigDecimal(1, salary);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeesList.add(extractEmployeeData(resultSet));
            }
        } 
        catch(SQLException e)
        {
            System.out.println("Error on fetching the data : ");
        }
        return employeesList;
    }

    private Employee extractEmployeeData(ResultSet resultSet) throws SQLException
    {
        return new Employee(
            resultSet.getInt("emp_id"),
            resultSet.getString("name"),
            resultSet.getString("designation"),
            resultSet.getString("department"),
            resultSet.getBigDecimal("salary"),
            resultSet.getDate("doj")
        );
    }

}
