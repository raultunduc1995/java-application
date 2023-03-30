package com.udacity.oop;

import java.util.Random;
import java.util.Scanner;

public final class GuessingGame {
    public static void main(String[] args) {
        var inputScanner = new Scanner(System.in);
        var generatedNumber = generateRandomNumber();
        int guesses = 0;
        guesses = playGuessingGame(inputScanner, generatedNumber, guesses);
        if (guesses == 10)
            System.out.println("I'm sorry. You have lost the game!");
        System.out.println("Game finished!");
    }

    private static int playGuessingGame(Scanner inputScanner, int generatedNumber, int guesses) {
        while (guesses < 10) {
            int number = getUserInputNumber(inputScanner);
            if (generatedNumber < number) {
                System.out.println("Generated number is less than introduced number. Try again!");
            } else if (generatedNumber > number)
                System.out.println("Generated number is greater than introduced number. Try again!");
            else {
                System.out.println("Number guessed correctly: " + number);
                break;
            }
            guesses++;
        }
        return guesses;
    }

    private static int generateRandomNumber() {
        var randomGenerator = new Random();
        return randomGenerator.nextInt(101);
    }

    private static int getUserInputNumber(Scanner inputScanner) {
        System.out.println("Guess a number between [0, 100]");
        return inputScanner.nextInt();
    }
}
