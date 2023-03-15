package com.example.four;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

// Type of Variable versus Class of an Object
interface Colorable {
    void color(final byte r, final byte g, final byte b);
}

class PointXY {
    protected int x, y;
}

class ColoredPoint extends PointXY implements Colorable {
    private byte r, g, b;

    @Override
    public void color(byte r, byte g, byte b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    void test() {
        PointXY point = new PointXY();
        ColoredPoint cp = new ColoredPoint();
        point = cp; // can happen because Point is superclass of ColoredPoint
        Colorable colorable = cp; // can happen because ColoredPoint implements Colorable interface
        Colorable anonymousColorable = new Colorable() {
            @Override
            public void color(byte r, byte g, byte b) {
            }
        }; // can happen because it declares an anonymous class that implements the Colorable interface.
    }
}
//////////////////////////////////

// Raw Types
final class TestRawTypes {
    private void testRawTypes() {
//        Outer.Inner<Integer> t = null; // Illegal because Outer generic-parameter is not declared -> It is not possible to access Inner as a partially raw type
//        inner.s = 3;
//        Outer<Double, Integer>.Inner inner = new Outer<Double, Integer>.Inner(); // Illegal
        Outer<Double> outer = new Outer<>();
        Outer.Inner<String> inner = outer.getInnerNewInstance(); // Legal
//        OuterSecond<Double, Integer>.Inner inner = new Outer.Inner(); // Illegal, same as before
        OuterSecond<Double, Integer> outerSecond = new OuterSecond<>();
        OuterSecond<Double, Integer>.Inner innerSecond = outerSecond.getInnerNewInstance(); // Legal
    }

    private final class Outer<T> {

        @Contract(value = " -> new", pure = true)
        public <S> @NotNull Inner<S> getInnerNewInstance() {
            return new Inner<>();
        }

        static final class Inner<S> {

            S s;
        }
    }

    private final class OuterSecond<T, S> {

        @Contract(value = " -> new", pure = true)
        public @NotNull Inner getInnerNewInstance() {
            return new Inner();
        }

        final class Inner {

            S s;
        }
    }
}
//////////////////////////////////

// Different variable declarations
final class Point {
    static int numPoints;   // numPoints is a class variable
    final int y;           // y is instance final variable -> it can be only initialized inline or in Class' constructor
    int x;                 // x is instance variable
    int[] w = new int[10];  // w[0] is an array component

    private Point(int y) {
        this.y = y;
    }

    int setX(final int x) {       // x is a method parameter
        int oldx = this.x;  // oldx is a local variable
        this.x = x;
        return oldx;
    }

    boolean equalAtX(final Object o) {
        if (o instanceof final Point p)  // p is a pattern variable
            return this.x == p.x;
        else
            return false;
    }
}
///////////////////////////////////

public final class TypesValuesVariables {
    private static Object obj;

    public TypesValuesVariables() {
    }

    public static void main(String[] args) {
        testPrimitiveTypeConvertions();
        testOverflow();
        testReflection();
    }

    private static void testPrimitiveTypeConvertions() {
        int i = 1000000;
        System.out.println(i * i); // -727379968
        System.out.println((long) i * i); // 1000000000000 -> because it's converted to long

        long number = Long.MAX_VALUE;
        System.out.println(number);
        System.out.println(++number); // Long.MIN_VALUE

        System.out.println("cast to int rounds toward 0: " + (int) number);
    }

    private static void testOverflow() {
        // An example of overflow:
        double d = 1e308;
        System.out.println("overflow produces infinity: " + (d + "*10==" + d * 10));
    }

    private static void testReflection() {
        TypesValuesVariables variable;
        try {
            variable = (TypesValuesVariables) Class.forName("com.example.four.TypesValuesVariables").getDeclaredConstructor().newInstance();
            System.out.println(variable.getClass().getName());
        } catch (final ClassNotFoundException | InvocationTargetException | InstantiationException |
                       IllegalAccessException |
                       NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void testHeapPollution() {
        List numbers = new ArrayList<Integer>(); // Always declare all type-arguments
        List<String> strings = numbers; // strings is declared as List<String> but it references a List<Integer>
    }
}