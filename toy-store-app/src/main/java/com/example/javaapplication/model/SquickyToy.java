package com.example.javaapplication.model;

public final class SquickyToy extends Toy {
    public SquickyToy(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "SquickyToy{" +
                "name='" + name + '\'' +
                '}';
    }
}
