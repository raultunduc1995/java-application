package com.udacity.oop;

import java.util.Scanner;

public final class ScannerExample {
    public static void main(String[] args) {
//        readStringFromSystemIn();
//        readIntegerFromSystemIn();
    }

    private static void readStringFromSystemIn() {
        System.out.println("Enter address: ");
        var scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        System.out.println("Address is: " + address);
    }

    private static void readIntegerFromSystemIn() {
        System.out.println("Enter a number: ");
        var scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Chosen number is: " + number);
    }
}
