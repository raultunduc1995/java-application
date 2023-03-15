package com.example.three;

public class LexicalStructure {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        testUnicodeCharacters();
        testIntegerNumbers();
        testStrings();

    }

    private static void testUnicodeCharacters() {
        String s = "\u001a";
        System.out.println(s);
    }

    private static void testIntegerNumbers() {
        // This is valid because is trated as an identifier, based on context
        int var = 12;
        int binaryNumber = 0b1_0011_1110; // 318
        var octalNumber = 0_2_3333; // 9947
        var hexNumber = 0xA1_2B22; // 10_562_338
        var posInfinity = 1f / 0f; // Float.POSITIVE_INFINITY
        var negInfitnity = -1d / 0d; // Double.NEGATIVE_INFINITY
        var nan = 0f / 0f; // Float.NaN
    }

    private static void testStrings() {
        String longText = """
                And he said: "You are my enemy\""""; // escape \" is necessary here
        String text = """
                this is a text block
                """;
        String code = """
                String text = \"""
                        this is a text block
                        \""";
                """;


        String hello = "Hello",
                world = " world",
                helloWorld = "Hello world";
//        helloWorld.equals(hello + world) => true
//        "Hello world".equals("Hello" + world) => true
//        "Hello world" == helloWorld => true -> both reference the same string
//        "Hello world" == ("Hello" + world) => false
        // rest of the combinations are true
    }
}