package zad1;
import java.io.File;
import java.io.FileNotFoundException;

public class Symulacja {
    private static int ileDoWypisania;

    private static void zresetujIleDoWypisania(Parametry parametry) {
        ileDoWypisania = parametry.dajCoIleWypisz();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Wczytuje parametry i sprawdza ich poprawność.
        Parametry parametry = new Parametry(new File(args[1]));
        parametry.sprawdźPoprawność();

        // Wczytuje planszę sprawdzając jej poprawność.
        Plansza plansza = new Plansza(new File(args[0]), parametry);

        // Wypisuje stan początkowy wszystkich robów przed rozpoczęciem symulacji.
        plansza.wypiszRoby();
        zresetujIleDoWypisania(parametry);

        for (int i = 0; i < parametry.dajIleTur(); i++) {
            plansza.zwiększTury();

            // Wykonuje programy wszystkich robów.
            int ileRobów = plansza.dajRoby().length;
            for (int j = 0; j < ileRobów; j++) {
                plansza.dajRoby()[j].wykonajProgram(plansza, parametry);
                plansza.dajRoby()[j].zmniejszEnergię(parametry.dajKosztTury());

                // Roby mogą się powielić, a następnie starzeją się o jedną turę.
                Powielanie.powiel(plansza, plansza.dajRoby()[j], parametry);
                plansza.dajRoby()[j].zwiększWiek();
            }

            // Roby z ujemną energią umierają.
            for (int j = 0; j < plansza.dajRoby().length; j++) {
                if (plansza.dajRoby()[j].dajEnergia() < 0) {
                    plansza.dajRoby()[j] = null;
                    plansza.zmniejszRoby();
                }
            }
            plansza.usuńRoby();

            // Zmniejsza licznik odnowienia jedzenia dla każdego pola żywieniowego.
            for (int x = 0; x < plansza.dajRozmiarPlanszyX(); x++) {
                for (int y = 0; y < plansza.dajRozmiarPlanszyY(); y++) {
                    Pole aktPole = plansza.dajPoleZPlanszy(x, y);

                    if (aktPole instanceof PoleŻywieniowe && ((PoleŻywieniowe) aktPole).dajIleDoOdrośnięcia() > 0) {
                        ((PoleŻywieniowe) aktPole).zmniejszIleDoOdrośnięcia();
                        if (((PoleŻywieniowe) aktPole).dajIleDoOdrośnięcia() == 0) {
                            plansza.zwiększŻwyność();
                        }
                    }
                }
            }

            // Wypisuje dane o symulacji na koniec tury.
            plansza.wypiszStanSymulacji();

            // Czasem też wypisze szczegółowe dane o robach.
            ileDoWypisania--;
            if (ileDoWypisania == 0) {
                zresetujIleDoWypisania(parametry);
                plansza.wypiszRoby();
            }
        }

        // Wypisuje dane o robach na koniec symulacji i kończy wykonywanie programu.
        plansza.wypiszRoby();
    }
}
