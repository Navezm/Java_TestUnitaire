package be.bxlformation.tu.exercices;

public class TriangleBF {
    private int a;
    private int b;
    private int c;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public String checkValidity(int a, int b, int c) throws TriangleException {
        if (a == 0 || b == 0 || c == 0) throw new TriangleException("Un des 3 côtés vaut 0");
        if (a < 0 || b < 0 || c < 0) throw new TriangleException("Un des côtés est négatif");
        if (a + b < c || a + c < b || b + c < a) throw new TriangleException("La somme de deux côtés est inférieure au troisième");
        if (a + b == c || a + c == b || b + c == a) throw new TriangleException("La somme de deux côtés vaut le troisième");
        if (a == c && c == b) return "équilatéral";
        if (a == b || a == c || b == c) return "isocèle";
        return "scalène";
    }
}
