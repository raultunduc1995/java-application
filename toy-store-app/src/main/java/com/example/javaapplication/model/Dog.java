package com.example.javaapplication.model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Dog {
    private final String name;
    private final float weight;
    private Toy toy;

    public Dog(@NotNull final String name, final float weight, @NotNull final Toy toy) {
        this.name = name;
        this.weight = weight;
        this.toy = toy;
    }

    public Dog(@NotNull final String name, final float weight) {
        this.name = name;
        this.weight = weight;
    }

    public static void executeCompanionMethod() {
    }

    public @NotNull String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public @NotNull Toy getToy() {
        return toy;
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", toy=" + toy +
                '}';
    }
}
