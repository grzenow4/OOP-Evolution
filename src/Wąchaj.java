package zad1;

public class Wąchaj {
    public static void wykonaj(Plansza plansza, Rob rob) {
        Pole górne = rob.górne(plansza);
        Pole dolne = rob.dolne(plansza);
        Pole lewe = rob.lewe(plansza);
        Pole prawe = rob.prawe(plansza);

        if (górne instanceof PoleŻywieniowe && ((PoleŻywieniowe) górne).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńZwrot(Zwrot.GÓRA);
        }
        else if (dolne instanceof PoleŻywieniowe && ((PoleŻywieniowe) dolne).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńZwrot(Zwrot.DÓŁ);
        }
        else if (lewe instanceof PoleŻywieniowe && ((PoleŻywieniowe) lewe).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńZwrot(Zwrot.LEWO);
        }
        else if (prawe instanceof PoleŻywieniowe && ((PoleŻywieniowe) prawe).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńZwrot(Zwrot.PRAWO);
        }
    }
}
