package com.example.student.entity;

public class Student 
{
    private int studentId;
    private String studentName;
    private String studentEmail;
    private int studentRollNo;

    public Student(){}

    public Student(int studentId, String studentName, String studentEmail, int studentRollNo) 
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentRollNo = studentRollNo;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public int getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(int studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

     @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
                + ", studentRollNo=" + studentRollNo + "]";
    }
}
