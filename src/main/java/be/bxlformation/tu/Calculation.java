package be.bxlformation.tu;

public class Calculation {

    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        calculation.division(1,0);
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public int division(int a, int b) {
        return a / b;
    }

}
