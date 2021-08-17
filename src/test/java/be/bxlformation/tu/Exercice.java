package be.bxlformation.tu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exercice {

    @Test
    void testNombre() {
        String a = "3", b = "4", c = "4";
        int result;
        NumberFormatException e = null;

        try {
            result = Integer.parseInt(a);
            result = Integer.parseInt(b);
            result = Integer.parseInt(c);
        } catch (NumberFormatException exc) {
            e = exc;
        }

        assertNull(e);
    }

    @Test
    void testZero() {
        Triangle triangle = new Triangle(4,3,1);
        assertTrue(triangle.getSideA() > 0 && triangle.getSideB() > 0 && triangle.getSideC() > 0);
    }

    @Test
    void testIso() {
        Triangle triangle = new Triangle(4, 5, 4);

        String phrase = triangle.checkTriangle();

        assertEquals("Isocèle", phrase);
    }

    @Test
    void testEqui() {
        Triangle triangle = new Triangle(7,7,7);

        String phrase = triangle.checkTriangle();

        assertEquals("Equilatéral", phrase);
    }

    @Test
    void testScalene() {
        Triangle triangle = new Triangle(4,6,7);

        String phrase = triangle.checkTriangle();

        assertEquals("Scalène", phrase);
    }

    @Test
    void testCote() {
        Triangle triangle = new Triangle(2,6,7);

        boolean testOk = false;

        if (triangle.getSideA() + triangle.getSideB() > triangle.getSideC() ||
            triangle.getSideB() + triangle.getSideC() > triangle.getSideA() ||
            triangle.getSideC() + triangle.getSideA() > triangle.getSideB()) {
            testOk = true;
        }

        assertTrue(testOk);
    }
}
