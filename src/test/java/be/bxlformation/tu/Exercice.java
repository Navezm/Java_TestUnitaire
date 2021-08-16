package be.bxlformation.tu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exercice {

    @Test
    void testTriangle() {
        String cote1 = "3", cote2 = "3", cote3 = "3";
        Triangle triangle = new Triangle(Integer.parseInt(cote1),Integer.parseInt(cote2),Integer.parseInt(cote3));
        assertTrue(triangle.getSideA() > 0 && triangle.getSideB() > 0 && triangle.getSideC() > 0);
        assertAll("testAll",
                () -> assertAll("testIso",
                        () -> assertEquals(triangle.getSideA(), triangle.getSideB()),
                        () -> assertEquals(triangle.getSideA(), triangle.getSideC()),
                        () -> assertEquals(triangle.getSideB(), triangle.getSideC())
                        ),
                () -> assertAll("testEqui",
                        () -> assertEquals(triangle.getSideA(), triangle.getSideB(), triangle.getSideC())
                        ),
                () -> assertAll("testScalene",
                        () -> assertNotEquals(triangle.getSideA(), triangle.getSideB(), triangle.getSideC())
                        )
        );
    }

}
