package com.example.hrapp;

import com.example.hrapp.model.Department;
import com.example.hrapp.model.Employee;

public class HrApp {
    public static void main(String[] args) {
        System.out.println("Hello from HR app");

        Department department = new Department("Department Education");
        System.out.println("Created department: " + department);

        department.addEmployee(new Employee(101, "Name_1", 1234.56));
        department.addEmployee(new Employee(102, "Name_2", 1200.34));
        department.addEmployee(new Employee(103, "Name_3", 1122.33));

        try {
            System.out.println("Employee 101: " + (department.getEmployee(101)));
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }

        for (Employee employee : department.getEmployees()) {
            System.out.println("Employee: " + employee);
        }

        System.out.println("Total Salary: " + department.getEmployeesSalary());

        System.out.println("Average Salary: " + department.getEmployeesAverageSalary());
    }
}
