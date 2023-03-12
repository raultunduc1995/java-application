package com.example.javaapplication.model;

public final class ChewToy extends Toy {
    private final String flavor;

    public ChewToy(String name, String flavor) {
        super(name);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return "ChewToy{" +
                "flavor='" + flavor + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
