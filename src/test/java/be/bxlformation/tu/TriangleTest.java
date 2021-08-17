package be.bxlformation.tu;

import org.junit.jupiter.api.*;

import java.lang.reflect.Field;

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
    class TestsEchecDeValidationDuTriangle {
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

        @Test
        void triangleDoitContenir3ProprietesDeTypeInt() {
            Field[] fields = TriangleBF.class.getDeclaredFields();

            assertEquals(3, fields.length);

            assertAll("proprieteTypeInt",
                    () -> assertEquals(int.class, fields[0].getType()),
                    () -> assertEquals(int.class, fields[1].getType()),
                    () -> assertEquals(int.class, fields[2].getType())
                    );
        }
    }

    @Nested
    class TestsSuccesValidationTriangle {
        @Test
        void triangleEstEquilateral() throws TriangleException {
            triangle.setB(3);
            triangle.setC(3);

            assertEquals("équilatéral", triangle.checkValidity(
                    triangle.getA(),
                    triangle.getB(),
                    triangle.getC()
            ));
        }

        @Test
        void triangleEstIsoceleDeBase_A() throws TriangleException {
            triangle.setB(6);

            assertEquals("isocèle", triangle.checkValidity(
                    triangle.getA(),
                    triangle.getB(),
                    triangle.getC()
            ));
        }

        @Test
        void triangleEstIsoceleDeBase_B() throws TriangleException {
            triangle.setA(6);

            assertEquals("isocèle", triangle.checkValidity(
                    triangle.getA(),
                    triangle.getB(),
                    triangle.getC()
            ));
        }

        @Test
        void triangleEstIsoceleDeBase_C() throws TriangleException {
            triangle.setA(4);

            assertEquals("isocèle", triangle.checkValidity(
                    triangle.getA(),
                    triangle.getB(),
                    triangle.getC()
            ));
        }

        @Test
        void triangleEstScalaire() throws TriangleException {
            assertEquals("scalène", triangle.checkValidity(
                    triangle.getA(),
                    triangle.getB(),
                    triangle.getC()
            ));
        }
    }

}
