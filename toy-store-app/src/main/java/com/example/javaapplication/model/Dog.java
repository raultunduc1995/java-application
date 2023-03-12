package com.example.javaapplication.model;

public final class Dog {
    public static void executeCompanionMethod() {
    }

    private final String name;
    private final float weight;
    private Toy toy;

    public Dog(String name, float weight, Toy toy) {
        this.name = name;
        this.weight = weight;
        this.toy = toy;
    }

    public Dog(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public Toy getToy() {
        return toy;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", toy=" + toy +
                '}';
    }
}
