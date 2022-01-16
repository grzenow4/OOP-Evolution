package zad1;

public class PoleŻywieniowe extends Pole {
    private int ileDoOdrośnięcia; // Jeśli 0 to znaczy, że jest jedzenie.

    public PoleŻywieniowe(int współrzędnaX, int współrzędnaY) {
        super(współrzędnaX, współrzędnaY);
        ileDoOdrośnięcia = 0;
    }

    public int dajIleDoOdrośnięcia() {
        return ileDoOdrośnięcia;
    }

    public void zresetujIleDoOdrośnięcia(Parametry parametry) {
        ileDoOdrośnięcia = parametry.dajIleRośnieJedzenie();
    }

    public void zmniejszIleDoOdrośnięcia() {
        ileDoOdrośnięcia--;
    }
}
