package com.example.javaapplication;

import com.example.javaapplication.model.ChewToy;
import com.example.javaapplication.model.Dog;

public class JavaApplication {
    public static void main(String[] args) {
        ChewToy toy = new ChewToy("Chew Toy", "sweet");
        var newDog = new Dog("Teddy", 32.5f);
        System.out.println("Hi from Java!");
        System.out.println("My toy: " + toy);
        System.out.println("Hi dog: " + newDog);
    }
}
