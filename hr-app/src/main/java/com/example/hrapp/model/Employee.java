package com.example.hrapp.model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record Employee(int id, String name, double salary) implements Comparable<Employee> {
    @Override
    public int id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double salary() {
        return salary;
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "{ " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                " }";
    }

    @Override
    public int compareTo(@NotNull Employee other) {
        return this.id - other.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}
