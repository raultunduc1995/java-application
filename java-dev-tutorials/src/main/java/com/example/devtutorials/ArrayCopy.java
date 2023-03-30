package com.example.devtutorials;

import java.util.Arrays;
import java.util.Comparator;

public final class ArrayCopy {
    public static void main(final String[] args) {
        final String[] copyFrom = {
                "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
                "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
                "Marocchino", "Ristretto"
        };
        final var copyTo = Arrays.copyOfRange(copyFrom, 5, copyFrom.length);
        Arrays.parallelSort(copyTo, Comparator.reverseOrder());
        System.out.println(Arrays.toString(copyTo));
    }
}
