package be.bxlformation.tu;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TriangleTest {

    private final TriangleBF triangle = new TriangleBF();

    @BeforeAll // Config globale avant toute chose
    void setUp() {
        triangle.setA(3);
        triangle.setB(4);
        triangle.setC(6);
    }

    @BeforeEach // Remettre la config avant chaque test
    void beforeEachTest(){
        triangle.setA(3);
        triangle.setB(4);
        triangle.setC(6);
    }

    @Nested
    class TestEchecDeValidationDuTriangle {

        @Test
        void uneValeurVautZeroTest_A() {
            triangle.setA(0);

            TriangleException exception = assertThrows(TriangleException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
                    );
            assertEquals("Un des 3 côtés vaut 0", exception.getMessage());
        }

        @Test
        void uneValeurVautZeroTest_B() {
            triangle.setB(0);

            TriangleException exception = assertThrows(TriangleException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des 3 côtés vaut 0", exception.getMessage());
        }

        @Test
        void uneValeurVautZeroTest_C() {
            triangle.setC(0);

            TriangleException exception = assertThrows(TriangleException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des 3 côtés vaut 0", exception.getMessage());
        }

        @Test
        void uneValeurEstNegative_A() {
            triangle.setA(-3);

            TriangleException exception = assertThrows(TriangleException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des côtés est négatif", exception.getMessage());
        }

        @Test
        void uneValeurEstNegative_B() {
            triangle.setB(-3);

            TriangleException exception = assertThrows(TriangleException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des côtés est négatif", exception.getMessage());
        }

        @Test
        void uneValeurEstNegative_C() {
            triangle.setC(-3);

            TriangleException exception = assertThrows(TriangleException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des côtés est négatif", exception.getMessage());
        }

        @Test
        void sommeDe_AEt_BEstInferieureOuEgaleA_C() {
            assertAll("sommeCotes_C",
                    () -> {
                        triangle.setC(7);
                        TriangleException exception = assertThrows(TriangleException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés vaut le troisième", exception.getMessage());
                    },
                    () -> {
                        triangle.setC(9);
                        TriangleException exception = assertThrows(TriangleException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés est inférieure au troisième", exception.getMessage());
                    }
                    );
        }

        @Test
        void sommeDe_AEt_CEstInferieureOuEgaleA_B() {
            assertAll("sommeCotes_B",
                    () -> {
                        triangle.setB(9);
                        TriangleException exception = assertThrows(TriangleException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés vaut le troisième", exception.getMessage());
                    },
                    () -> {
                        triangle.setB(12);
                        TriangleException exception = assertThrows(TriangleException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés est inférieure au troisième", exception.getMessage());
                    }
            );
        }

        @Test
        void sommeDe_BEt_CEstInferieureOuEgaleA_A() {
            assertAll("sommeCotes_A",
                    () -> {
                        triangle.setA(10);

                        TriangleException exception = assertThrows(TriangleException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés vaut le troisième", exception.getMessage());
                    },
                    () -> {
                        triangle.setA(12);
                        TriangleException exception = assertThrows(TriangleException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés est inférieure au troisième", exception.getMessage());
                    }
            );
        }
    }

}
