package com.examly;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.examly.entity.Employee;
import com.examly.service.EmployeeService;
import com.examly.service.EmployeeServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeServiceImpl();
        int choice;
        do
        {
            System.out.println("Employee Management");
            System.out.println("-------------------------");
            System.out.println("1) Add Employee");
            System.out.println("2) Update Employee");
            System.out.println("3) Delete Employee");
            System.out.println("4) View Employee");
            System.out.println("5) Search Employee by Designation");
            System.out.println("6) Filter Employee by department");
            System.out.println("7) Filter Employee by salary range");
            System.out.println("0) Exit");
            System.out.println("--------------------------------");
            System.out.println("Enter your choice");
            choice = Integer.parseInt(input.nextLine());
            switch(choice)
            {
                case 1 -> addEmployee(input, employeeService);
                case 2 -> updateEmployee(input, employeeService);
                case 3 -> deleteEmployee(input, employeeService);
                case 4 -> getAllEmployees(employeeService);
                case 5 -> searchByDesignation(input, employeeService);
                case 6 -> filterByDepartment(input, employeeService);
                case 7 -> filteBySalaryRange(input, employeeService);
                case 0 -> System.out.println("System exit");
                default -> System.out.println("Invalid Choice");
            }
        }
        while(choice!=0);
    }

    private static void addEmployee(Scanner input,EmployeeService service)
    {
        System.out.println("Enter the employee Id : ");
        int String = Integer.parseInt(input.nextLine());
        System.out.println("Enter the  employee Name : ");
        String name = input.nextLine();
        System.out.println("Enter the employee designation : ");
        String designation = input.nextLine();
        System.out.println("Enter the employee department : ");
        String department = input.nextLine();
        System.out.println("Enter the employee Salary : ");
        BigDecimal salary = input.nextBigDecimal();
        input.nextLine();
        System.out.println("Enter the employee date of joining (yyyy-mm-dd) : ");
        String date = input.nextLine();
        Date doj = Date.valueOf(date);

        Employee employee = new Employee(String, name, designation, department, salary, doj);
        
        String result = service.addEmployee(employee);
        System.out.println(result);
    }

    private static void updateEmployee(Scanner input,EmployeeService service)
    {
        System.out.println("Enter the employee Id : ");
        int String = Integer.parseInt(input.nextLine());
        System.out.println("Enter the  employee Name : ");
        String name = input.nextLine();
        System.out.println("Enter the employee designation : ");
        String designation = input.nextLine();
        System.out.println("Enter the employee department : ");
        String department = input.nextLine();
        System.out.println("Enter the employee Salary : ");
        BigDecimal salary = input.nextBigDecimal();
        input.nextLine();
        System.out.println("Enter the employee date of joining (yyyy-mm-dd) : ");
        String date = input.nextLine();
        Date doj = Date.valueOf(date);

        Employee employee = new Employee(String, name, designation, department, salary, doj);
        
        String result = service.updateEmployee(employee);
        System.out.println(result);
    }

    private static void deleteEmployee(Scanner input, EmployeeService service)
    {
        System.out.println("Enter the employee Id to delete : ");
        int empId = Integer.parseInt(input.nextLine());

        String result = service.deleteEmployee(empId);

        System.out.println(result);
    }

    private static void getAllEmployees(EmployeeService service)
    {
        List<Employee> empList = new ArrayList<>();
        empList = service.getAllEmployees();
        if(empList.isEmpty())
        {
            System.out.println("No records is table");
        }
        else
        {
            empList.forEach(System.out::println);
        }
    }

    private static void searchByDesignation(Scanner input, EmployeeService service)
    {
        List<Employee> employeeList = new ArrayList<>();
        System.out.println("Enter the designation to search :");
        String designation = input.nextLine();
        employeeList = service.searchByDesignation(designation);
        if(employeeList.isEmpty())
        {
            System.out.println("There is not record found ...");
        }
        else
        {
            employeeList.forEach(System.out::println);
        }
    }

    private static void filterByDepartment(Scanner input, EmployeeService service)
    {
        List<Employee> employeesList = new ArrayList<>();
        System.out.println("Enter the department to filter : ");
        String department = input.nextLine();
        employeesList = service.filterByDepartment(department);
        if(employeesList.isEmpty())
        {
            System.out.println("There is no record found ...");
        }
        else
        {
            employeesList.forEach(System.out::println);
        }
    }
    private static void filteBySalaryRange(Scanner input,EmployeeService service)
    {
        List<Employee> employeeList = new ArrayList<>();
        System.out.println("Enter the salary : ");
        BigDecimal salary = input.nextBigDecimal();
        input.nextLine();
        employeeList = service.filterBySalaryRange(salary);
        if(employeeList.isEmpty())
        {
            System.out.println("There is no record found..");
        }
        else
        {
            employeeList.forEach(System.out::println);
        }
    }
}