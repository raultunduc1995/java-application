package com.example.hrapp.model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public final class Department {
    private final String name;
    private Employee[] employees;
    private int lastEmployeeIndex = -1;

    public Department(String name) {
        this.name = name;
        this.employees = new Employee[10];
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "Department{" +
                "name='" + name + "'" +
                ", employees=" + Arrays.toString(getEmployees()) +
                '}';
    }

    public boolean addEmployee(Employee employee) {
        if (employee == null)
            return false;
        if (!isFirstElement() && !doesNextIndexExist())
            increaseEmployeesCapacity();
        employees[++lastEmployeeIndex] = employee;
        return true;
    }

    private boolean isFirstElement() {
        return lastEmployeeIndex == -1;
    }

    private boolean doesNextIndexExist() {
        return (lastEmployeeIndex + 1) < employees.length;
    }

    private void increaseEmployeesCapacity() {
        final Employee[] newEmployees = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        employees = newEmployees;
    }

    @Contract(pure = true)
    public @Nullable Employee getEmployee(int employeeId) {
        int i = 0;
        while (i <= lastEmployeeIndex) {
            if (employees[i].id() == employeeId)
                return employees[i];
            i++;
        }
        return null;
    }

    public double getEmployeesAverageSalary() {
        if (lastEmployeeIndex == -1)
            return 0.0;
        return getEmployeesSalary() / (lastEmployeeIndex + 1);
    }

    public double getEmployeesSalary() {
        double totalSalary = 0.0;
        for (int i = 0; i <= lastEmployeeIndex; i++) {
            totalSalary += employees[i].salary();
        }
        return totalSalary;
    }

    @Contract(pure = true)
    public Employee @NotNull [] getEmployees() {
        Employee[] result = new Employee[lastEmployeeIndex + 1];
        int i;
        for (i = 0; i <= lastEmployeeIndex; i++) {
            result[i] = employees[i];
        }
        return result;
    }
}
