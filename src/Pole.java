package zad1;

public class Pole {
    private int współrzędnaX;
    private int współrzędnaY;

    public Pole(int współrzędnaX, int współrzędnaY) {
        this.współrzędnaX = współrzędnaX;
        this.współrzędnaY = współrzędnaY;
    }

    public int dajWspółrzędnaX() {
        return współrzędnaX;
    }

    public int dajWspółrzędnaY() {
        return współrzędnaY;
    }
}
