package be.bxlformation.tu.assertions;

import be.bxlformation.tu.Calculation;
import be.bxlformation.tu.Personne;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DemoAssertion {

    private final Calculation calculation = new Calculation();

    private final Personne p = new Personne("Navez", "Martin");

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

    @Disabled
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
        String fields = Arrays.toString(p.getClass().getDeclaredFields());
        assertEquals("[private java.lang.String be.bxlformation.tu.Personne.name, private java.lang.String be.bxlformation.tu.Personne.surname]", fields);
    }

    @Test
    void testPersonne() {
        assertAll("person",
                    () -> assertEquals("Navez", p.getName()),
                    () -> assertEquals("Martin", p.getSurname())
                );
    }

    @Test
    void dependantAssertions() {
        assertAll("properties",
                () -> {
                    assertNotNull(p.getSurname());
                    assertAll("first_name",
                            () -> assertTrue(p.getSurname().startsWith("M")),
                            () -> assertTrue(p.getSurname().endsWith("n"))
                            );
                },
                () -> {
                    assertNotNull(p.getName());
                    assertAll("last_name",
                            () -> assertTrue(p.getName().contains("ez"))
                    );
                }
        );
    }

    // Création d'une annotation personnalisée
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledOnOs(OS.WINDOWS) // Permet de faire tourner ce test seulement si on est sur Windows
    @interface TestOnWindows {}

    @TestOnWindows
    void OSTests() {

    }

    @Test
    @EnabledForJreRange(
            min = JRE.JAVA_8,
            max = JRE.JAVA_12
    )
    @EnabledOnJre(JRE.JAVA_8)
    void onlyOnJava8() {

    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitsArchitecture() {

    }

    @Test
    @EnabledIf("conditionPersonnalisee")
    void enabledByCondition() {

    }

    @Test
    @DisabledIf("conditionPersonnalisee")
    void disabledByCondition() {

    }

    boolean conditionPersonnalisee() {
        return true;
    }

}
