package zad1;
import java.util.Random;

public class Powielanie {
    public static void powiel(Plansza plansza, Rob rob, Parametry parametry) {
        Random r = new Random();
        double n = r.nextDouble();
        boolean czyZachodziPr = (n < parametry.dajPrPowielenia());

        if (czyZachodziPr && rob.dajEnergia() >= parametry.dajLimitPowielania()) {
            double ułamekEnergii = parametry.dajUłamekEnergiiRodzica() * rob.dajEnergia();
            rob.zmniejszEnergię((int) ułamekEnergii);
            Rob nowyRob = new Rob((int) ułamekEnergii, rob.dajProgram(), rob.dajWspX(), rob.dajWspY(), rob.dajZwrot());
            Obróć.przeciwnie(nowyRob);
            Mutacje.mutuj(nowyRob, parametry);
            plansza.dodajRoba(nowyRob);
        }
    }
}
