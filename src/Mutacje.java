package zad1;
import java.util.Random;

public class Mutacje {
    private static void usuńInstr(Rob rob, Parametry parametry) {
        Random r = new Random();
        double n = r.nextDouble();
        boolean czyZachodziPr = (n < parametry.dajPrDodaniaInstr());

        if (czyZachodziPr && rob.dajProgram().length > 0) {
            char[] nowyProgram = new char[rob.dajProgram().length - 1];
            for (int i = 0; i < rob.dajProgram().length - 1; i++) {
                nowyProgram[i] = rob.dajProgram()[i];
            }

            rob.zmieńProgram(nowyProgram);
        }
    }

    private static void dodajInstr(Rob rob, Parametry parametry) {
        Random r = new Random();
        double n = r.nextDouble();
        boolean czyZachodziPr = (n < parametry.dajPrUsunięciaInstr());

        if (czyZachodziPr) {
            char[] nowyProgram = new char[rob.dajProgram().length + 1];
            for (int i = 0; i < rob.dajProgram().length; i++) {
                nowyProgram[i] = rob.dajProgram()[i];
            }
            int m = r.nextInt(parametry.dajSpisInstr().length);
            nowyProgram[rob.dajProgram().length] = parametry.dajSpisInstr()[m];

            rob.zmieńProgram(nowyProgram);
        }
    }

    private static void zmieńInstr(Rob rob, Parametry parametry) {
        Random r = new Random();
        double n = r.nextDouble();
        boolean czyZachodziPr = (n < parametry.dajPrZmianyInstr());

        if (czyZachodziPr && rob.dajProgram().length > 0) {
            char[] nowyProgram = rob.dajProgram();
            int m = r.nextInt(parametry.dajSpisInstr().length);
            nowyProgram[rob.dajProgram().length - 1] = parametry.dajSpisInstr()[m];

            rob.zmieńProgram(nowyProgram);
        }
    }

    public static void mutuj(Rob rob, Parametry parametry) {
        usuńInstr(rob, parametry);
        dodajInstr(rob, parametry);
        zmieńInstr(rob, parametry);
    }
}
