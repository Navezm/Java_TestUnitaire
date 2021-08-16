package be.bxlformation.tu.assertions;

import be.bxlformation.tu.Calculation;
import be.bxlformation.tu.Personne;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DemoAssertion {

    private final Calculation calculation = new Calculation();

    @Test
    void standardAssertions() {
        assertEquals(2, calculation.addition(1,1));
        assertEquals(2, calculation.addition(1,1), "1 + 2 ne fait pas 2 !");
        assertTrue(1 < 2, "La condition retourne faux");
    }

    @Test
    void exceptiontesting() {
        Calculation calculation1 = null;
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> calculation1.addition(1,1)
        );
    }

    @Test
    void divisionParZeroTest() {
        Calculation calculation = new Calculation();
        ArithmeticException e = assertThrows(
                ArithmeticException.class,
                () -> calculation.division(5,0)
        );
        assertEquals("/ by zero", e.getMessage());
    }

    @Test
    void timeOutNotExceeded() {
        String result = assertTimeout(Duration.ofMillis(1), DemoAssertion::nawak);
        assertEquals("nawak", result);
    }

    private static String nawak() {
        return "nawak";
    }

    /**
     * Test qu'un objet personne contienne bien un nom et un prenom
     */

    @Test
    void testPersonneContientNomEtPrenom() {
        Personne personne = new Personne();
        String fields = Arrays.toString(personne.getClass().getDeclaredFields());
        assertEquals("[private java.lang.String be.bxlformation.tu.Personne.nom, private java.lang.String be.bxlformation.tu.Personne.prenom]", fields);
    }

//    @Test
//    void testDivisionParZero() {
//        ArithmeticException e = null;
//        try {
//            calculation.division(1, 2);
//        } catch (ArithmeticException exc) {
//            e = exc;
//        }
//        assertNull(e);
//    }

}
