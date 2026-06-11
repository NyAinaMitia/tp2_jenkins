package com.triangle;

public class Triangle {

    public enum Type { EQUILATERAL, ISOSCELES, SCALENE, INVALID }

    public static Type getType(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return Type.INVALID;
        if (a + b <= c || a + c <= b || b + c <= a) return Type.INVALID;
        if (a == b && b == c) return Type.EQUILATERAL;
        if (a == b || b == c || a == c) return Type.ISOSCELES;
        return Type.SCALENE;
    }

    public static void main(String[] args) {
        System.out.println("Triangle(3,3,3) = " + getType(3, 3, 3));
        System.out.println("Triangle(3,3,5) = " + getType(3, 3, 5));
        System.out.println("Triangle(3,4,5) = " + getType(3, 4, 5));
    }
}