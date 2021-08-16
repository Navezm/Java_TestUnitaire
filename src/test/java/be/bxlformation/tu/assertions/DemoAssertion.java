package be.bxlformation.tu.assertions;

import be.bxlformation.tu.Calculation;
import org.junit.jupiter.api.Test;
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
    void testDivisionParZero() {
        ArithmeticException e = null;

        try {
            calculation.division(1, 2);
        } catch (ArithmeticException exc) {
            e = exc;
        }

        assertNull(e);
    }

}
