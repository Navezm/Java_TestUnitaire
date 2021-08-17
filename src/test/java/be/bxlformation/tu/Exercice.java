package be.bxlformation.tu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exercice {

    @Test
    void testNombre() {
        String inputUtilisateur_a = "3", inputUtilisateur_b = "4", inputUtilisateur_c = "4";
        int result;
        NumberFormatException e = null;

        try {
            result = Integer.parseInt(inputUtilisateur_a);
            result = Integer.parseInt(inputUtilisateur_b);
            result = Integer.parseInt(inputUtilisateur_c);
        } catch (NumberFormatException exc) {
            e = exc;
        }

        assertNull(e);
    }

    @Test
    void testZero() {
        Triangle triangle = new Triangle(4,3,2);
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

}
