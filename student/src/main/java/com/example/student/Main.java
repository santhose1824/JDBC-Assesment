package com.example.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import com.example.student.service.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentService studentService = new StudentServiceImpl();
        int choice;
        do
        {
            System.out.println("Student Managment System...");
            System.out.println("============================");
            System.out.println("1) Add New Student");
            System.out.println("2) Update Student");
            System.out.println("3) Delete Student");
            System.out.println("4) View All Students");
            System.out.println("==========================");
            System.out.println("Enter your chocie : ");
            choice = Integer.parseInt(input.nextLine());

            switch(choice)
            {
                case 1  -> addStudent(input, studentService);
                case 2  -> updateStudent(input, studentService);
                case 3  -> deleteStudent(input, studentService);
                case 4  -> viewStudents(studentService);
                case 0  -> System.out.println("System exit");
                default -> System.out.println("Invalid choice");
            }
        }
        while(choice!=0);
    }

    private static void addStudent(Scanner input,StudentService studentService)
    {
        System.out.println("Enter the student Id : ");
        int studId = Integer.parseInt(input.nextLine());
        System.out.println("Enter the student Name : ");
        String studName = input.nextLine();
        System.out.println("Enter the student Email : ");
        String studEmail = input.nextLine();
        System.out.println("Enter the student Roll No : ");
        int studRollNo = Integer.parseInt(input.nextLine());

        Student student = new Student(studId,studName,studEmail,studRollNo);

        System.out.println(studentService.addStudentDetails(student));
    }
    private static void updateStudent(Scanner input,StudentService studentService)
    {
        System.out.println("Enter the student Id : ");
        int studId = Integer.parseInt(input.nextLine());
        System.out.println("Enter the new student Name : ");
        String studName = input.nextLine();
        System.out.println("Enter the new student Email : ");
        String studEmail = input.nextLine();
        System.out.println("Enter the new student Roll No : ");
        int studRollNo = Integer.parseInt(input.nextLine());

        Student student = new Student(studId,studName,studEmail,studRollNo);

        System.out.println(studentService.updateStudentDetails(student));
    }
    private static void deleteStudent(Scanner input,StudentService studentService)
    {
        System.out.println("Enter the student Id : ");
        int studId = Integer.parseInt(input.nextLine());
        System.out.println(studentService.deleteStudentDetails(studId));
    }

    private static void viewStudents(StudentService studentService)
    {
        List<Student> studentDetails = new ArrayList<>();

        studentDetails = studentService.viewAllStudents();

        studentDetails.forEach(System.out::println);
    }
}