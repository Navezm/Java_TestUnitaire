package be.bxlformation.tu.exercices;

public class Triangle {

    private int sideA;
    private int sideB;
    private int sideC;

    private Triangle(){}

    public Triangle(int sideA, int sideB, int sideC) {
        if (sideA > 0 && sideB > 0 && sideC > 0) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
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
        String phrase;
        if (this.getSideA() == this.getSideB() &&
                this.getSideB() == this.getSideC()) {
            return phrase = "Equilatéral";
        } else if (this.getSideA() == this.getSideB() ||
                this.getSideA() == this.getSideC() ||
                this.getSideB() == this.getSideC()) {
            return phrase = "Isocèle";
        } else {
            return phrase = "Scalène";
        }
    }
}
