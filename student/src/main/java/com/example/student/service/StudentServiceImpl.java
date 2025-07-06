package com.example.student.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.student.entity.Student;
import com.example.student.util.DBConnectionUtil;

public class StudentServiceImpl implements StudentService
{

    @Override
    public String addStudentDetails(Student student)
    {
        String sql = "INSERT INTO student (stdId,stdName,stdEmail,stdRollNo) VALUES(?,?,?,?)";
        try 
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        )
        {
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setString(3, student.getStudentEmail());
            preparedStatement.setInt(4, student.getStudentRollNo());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0 ? "Student Data Added Successfully" : "Failed to add the Student Data";
        } 
        catch (SQLException e) {
            System.out.println("Error on adding student Data : ");
            return e.toString();
        }
    }


    public String updateStudentDetails(Student student)
    {
        String sql = "UPDATE student SET stdName = ?, stdEmail = ?, stdRollNo = ? WHERE stdId = ?";
        try 
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        )
        {
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setString(3, student.getStudentEmail());
            preparedStatement.setInt(4, student.getStudentRollNo());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0 ? "Student Data Added Successfully" : "Failed to add the Student Data";
        } 
        catch (SQLException e) {
            System.out.println("Error on adding student Data : ");
            return e.toString();
        }
    }



    public String deleteStudentDetails(int studId)
    {
        String sql = "DELETE FROM student WHERE stdId = ?";
        try 
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        )
        {
            preparedStatement.setInt(1, studId);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0 ? "Student Data Added Successfully" : "Failed to add the Student Data";
        } 
        catch (SQLException e) {
            System.out.println("Error on adding student Data : ");
            return e.toString();
        }
    }

    public List<Student>viewAllStudents()
    {
        String sql = "SELECT * FROM student";
        List<Student> studentDetails = new ArrayList<>();
        try 
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
        )
        {
            
            while (resultSet.next()) 
            {
                studentDetails.add(extractedStudentDetails(resultSet));
            }
           
        } 
        catch (SQLException e) {
            System.out.println("Error on adding student Data : ");
        }

        return studentDetails;
    }


    private Student extractedStudentDetails(ResultSet resultSet) throws SQLException
    {
        return new Student(
            resultSet.getInt("stdId"),
            resultSet.getString("stdName"),
            resultSet.getString("stdEmail"),
            resultSet.getInt("stdRollNo")
        );
    }
}
