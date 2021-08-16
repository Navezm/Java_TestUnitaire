package be.bxlformation.tu;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Calculation {

    public static void main(String[] args) {
        Personne personne = new Personne();
        String fields = Arrays.toString(personne.getClass().getDeclaredFields());
        System.out.println(fields);
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public int division(int a, int b) {
        return a / b;
    }

}
