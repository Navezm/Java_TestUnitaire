package be.bxlformation.tu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {

    /**
     * Vérif d'une addition de 2 nbre entiers
     * - Les 2 doivent être entiers
     * - Aucun des 2 nombres ne sont nuls
     * - Que le résultat de 2 nombres corresponde au résultat souhaité
     */

    // ETAPE D'IMPLEMENTATION D'UN TEST
    // Arrange - Act - Assert

    // Arrange : initialiser tous les entrants nécessaire
    // Act : exécution du test avec les entrants et sauvegarde des sortants
    // Assert : valider les sortant en fonction de ce qui est attendu avec nos entrants

    @Test
    void premierTest() {
        // ARRANGE
        int a = 3, b = 4;
        Calculation firstTest = new Calculation();

        // ACT
        int result = firstTest.addition(a,b);

        // ASSERT
        assertEquals(result, 7);
    }

}
