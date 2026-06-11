package com.triangle;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testEquilateral() {
        assertEquals(Triangle.Type.EQUILATERAL, Triangle.getType(3, 3, 3));
    }

    @Test
    public void testIsosceles() {
        assertEquals(Triangle.Type.ISOSCELES, Triangle.getType(3, 3, 5));
    }

    @Test
    public void testScalene() {
        assertEquals(Triangle.Type.SCALENE, Triangle.getType(3, 4, 5));
    }

    @Test
    public void testInvalid() {
        assertEquals(Triangle.Type.INVALID, Triangle.getType(1, 2, 10));
        assertEquals(Triangle.Type.INVALID, Triangle.getType(0, 3, 3));
    }
}