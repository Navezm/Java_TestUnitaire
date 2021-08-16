package be.bxlformation.tu;

import java.util.Scanner;

public class Triangle {

    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(){}

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }

    public String checkTriangle() {
        String phrase = null;
        Scanner scan = new Scanner(System.in);

        System.out.println("Donne moi un premier chiffre");
        int a = Integer.parseInt(scan.nextLine());
        System.out.println("Donne en moi un autre");
        int b = Integer.parseInt(scan.nextLine());
        System.out.println("Et un dernier");
        int c = Integer.parseInt(scan.nextLine());

        if (a == b && b == c) {
            return phrase = "Equilatéral";
        } else if (a == b || a == c || b == c) {
            return phrase = "Isocèle";
        } else {
            return phrase = "Scalène";
        }

    }
}
