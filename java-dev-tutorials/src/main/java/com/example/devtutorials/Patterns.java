package com.example.devtutorials;

public final class Patterns {
    public static void main(String[] args) {
        checkIfPoint(new Point(1, 1));
        checkIfPoint(new Cube(1, 2, 3));
        checkIfPoint(new Object());
    }

    static void checkIfPoint(Object object) {
        /*
         * Available only in JDK 19+
         *    if (object instanceof Point (int x, int y)) {
         *    }
         */
        if (object instanceof Point point) {
            point.x();
            point.y();
        }

        System.out.println(
                switch (object) {
                    case Point point -> "I am point " + point;
                    case Cube cube -> "I am cube " + cube;
                    default -> "I am other";
                }
        );
    }

    private record Point(int x, int y) {
    }

    private record Cube(int x, int y, int z) {
    }
}
