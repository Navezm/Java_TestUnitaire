package be.bxlformation.tu.assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DemoParameterizedTest {

    enum JourSemaine {
        LUNDI,
        MARDI,
        MERCREDI,
        JEUDI,
        VENDREDI,
        SAMEDI,
        DIMANCHE
    }

    @ParameterizedTest
    @ValueSource(strings = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"})
    void estPresentDansEnum(String jour) {
        assertNotNull(JourSemaine.valueOf(jour.toUpperCase()));
    }

    @ParameterizedTest
    @EnumSource(JourSemaine.class)
    void estPresent(JourSemaine jourSemaine) {
        assertNotNull(jourSemaine);
    }

    @ParameterizedTest
    @EnumSource(names = {"LUNDI", "JEUDI"})
    void estInclusDansEnum(JourSemaine jour) {
        assertTrue(EnumSet.of(JourSemaine.LUNDI, JourSemaine.JEUDI).contains(jour));
    }

    @ParameterizedTest
    @MethodSource("fournisseur") // Pour faire cette injection, la méthode doit être statique
    void estInjecteParUneMethode(String argument) {
        assertTrue(argument.endsWith("e"));
    }

    static Stream<String> fournisseur() {
        return Stream.of("pomme", "poire", "banane");
    }
}
