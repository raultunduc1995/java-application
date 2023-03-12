package com.example.javaapplication.model;

public abstract class Toy {
    protected final String name;

    public Toy(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                '}';
    }
}
