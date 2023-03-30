package com.example.devtutorials;

public final class Labels {
    public static void main(final String[] args) {
        final int[] array = {
                1, 2, 3, 4,
                5, 6, 7, 8
        };
        final int searchedNumber = 7;
        boolean found = false;
        search:
        while (true)
            for (int element : array)
                if (searchedNumber == element) {
                    found = true;
                    break search;
                }
        System.out.println(found ? "Found the number" : "");
    }
}
