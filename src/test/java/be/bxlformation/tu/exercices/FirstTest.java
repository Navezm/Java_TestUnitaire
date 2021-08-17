package be.bxlformation.tu.exercices;

import be.bxlformation.tu.Calculation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Première classe de test")
//@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
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
    @DisplayName("Ceci est mon premier test sur la validité de l'addition")
    void premierTestSucces() {
        // ARRANGE
        int a = 3, b = 4;
        Calculation firstTest = new Calculation();

        // ACT
        int result = firstTest.addition(a,b);

        // ASSERT
        assertEquals(result, 7);
    }

    @Test
    void premierTestFailCarPasEntier() {
        // ARRANGE
        String inputUtilisateur_a = "3", inputUtilisateur_b = "4";
        int result;
        NumberFormatException e = null;

        // ACT
        try {
            result = Integer.parseInt(inputUtilisateur_a);
            result = Integer.parseInt(inputUtilisateur_b);
        } catch (NumberFormatException exc) {
            e = exc;

        }

        // ASSERT
        assertNull(e);
    }

    @Test
    void nom_de_test_autogenere() {

    }
}
