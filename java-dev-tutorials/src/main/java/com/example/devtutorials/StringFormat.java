package com.example.devtutorials;

import java.util.Locale;

public final class StringFormat {
    public static void main(String[] args) {
        System.out.format(
                "The value of the float " + "variable is %.1f, while the " +
                        "value of the integer variable " + "is %d, and the string is %s%n",
                1.1f, 1, "string-1");
        System.out.format(Locale.FRANCE,
                "The value of the float " + "variable is %.2f, while the " +
                        "value of the integer variable " + "is %d, and the string is %s%n",
                1.1f, 1, "string-1");
    }
}
