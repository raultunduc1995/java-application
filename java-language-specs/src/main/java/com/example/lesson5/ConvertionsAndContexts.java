package com.example.lesson5;

public class ConvertionsAndContexts {
    public static void main(String[] args) {
        testConversions();
    }

    private static void testConversions() {
        // narrow conversion
        int i = (int) 5.5;

        // String conversion
        System.out.println("(int)5.5 = " + i);

        // Widening conversion
        float f = i;

        // Narrow conversion
        int secondI = (int) f;

        // Integer infinity
        int infinity = (int) Float.POSITIVE_INFINITY;
        System.out.println(infinity);
        int negativeInfinity = (int) Float.NEGATIVE_INFINITY;
        System.out.println(negativeInfinity);

        // Binary numberic promotion
        f *= i;

        // Invocation conversion
        double d = Math.sin(f); // f is converted do double
    }
}
