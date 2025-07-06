package com.example.student.service;

import com.example.student.entity.Student;
import java.util.List;

public interface StudentService 
{
    String addStudentDetails(Student student);
    String updateStudentDetails(Student student);
    String deleteStudentDetails(int studentId);
    List<Student> viewAllStudents();
}
