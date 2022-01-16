package zad1;

public class Jedz {
    public static void wykonaj(Plansza plansza, Rob rob, Parametry parametry) {
        Pole leweGórne = rob.leweGórne(plansza);
        Pole praweGórne = rob.praweGórne(plansza);
        Pole leweDolne = rob.leweDolne(plansza);
        Pole praweDolne = rob.praweDolne(plansza);
        Pole górne = rob.górne(plansza);
        Pole dolne = rob.dolne(plansza);
        Pole lewe = rob.lewe(plansza);
        Pole prawe = rob.prawe(plansza);

        if (leweGórne instanceof PoleŻywieniowe && ((PoleŻywieniowe) leweGórne).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńWspX(leweGórne.dajWspółrzędnaX());
            rob.zmieńWspY(leweGórne.dajWspółrzędnaY());
            ((PoleŻywieniowe) leweGórne).zresetujIleDoOdrośnięcia(parametry);
            if (parametry.dajIleRośnieJedzenie() != 0) {
                plansza.zmniejszŻywność();
            }
            rob.zwiększEnergię(parametry.dajIleDajeJedzenie());
        }
        else if (praweGórne instanceof PoleŻywieniowe && ((PoleŻywieniowe) praweGórne).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńWspX(praweGórne.dajWspółrzędnaX());
            rob.zmieńWspY(praweGórne.dajWspółrzędnaY());
            ((PoleŻywieniowe) praweGórne).zresetujIleDoOdrośnięcia(parametry);
            if (parametry.dajIleRośnieJedzenie() != 0) {
                plansza.zmniejszŻywność();
            }
            rob.zwiększEnergię(parametry.dajIleDajeJedzenie());
        }
        else if (leweDolne instanceof PoleŻywieniowe && ((PoleŻywieniowe) leweDolne).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńWspX(leweDolne.dajWspółrzędnaX());
            rob.zmieńWspY(leweDolne.dajWspółrzędnaY());
            ((PoleŻywieniowe) leweDolne).zresetujIleDoOdrośnięcia(parametry);
            if (parametry.dajIleRośnieJedzenie() != 0) {
                plansza.zmniejszŻywność();
            }
            rob.zwiększEnergię(parametry.dajIleDajeJedzenie());
        }
        else if (praweDolne instanceof PoleŻywieniowe && ((PoleŻywieniowe) praweDolne).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńWspX(praweDolne.dajWspółrzędnaX());
            rob.zmieńWspY(praweDolne.dajWspółrzędnaY());
            ((PoleŻywieniowe) praweDolne).zresetujIleDoOdrośnięcia(parametry);
            if (parametry.dajIleRośnieJedzenie() != 0) {
                plansza.zmniejszŻywność();
            }
            rob.zwiększEnergię(parametry.dajIleDajeJedzenie());
        }
        else if (górne instanceof PoleŻywieniowe && ((PoleŻywieniowe) górne).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńWspX(górne.dajWspółrzędnaX());
            rob.zmieńWspY(górne.dajWspółrzędnaY());
            ((PoleŻywieniowe) górne).zresetujIleDoOdrośnięcia(parametry);
            if (parametry.dajIleRośnieJedzenie() != 0) {
                plansza.zmniejszŻywność();
            }
            rob.zwiększEnergię(parametry.dajIleDajeJedzenie());
        }
        else if (dolne instanceof PoleŻywieniowe && ((PoleŻywieniowe) dolne).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńWspX(dolne.dajWspółrzędnaX());
            rob.zmieńWspY(dolne.dajWspółrzędnaY());
            ((PoleŻywieniowe) dolne).zresetujIleDoOdrośnięcia(parametry);
            if (parametry.dajIleRośnieJedzenie() != 0) {
                plansza.zmniejszŻywność();
            }
            rob.zwiększEnergię(parametry.dajIleDajeJedzenie());
        }
        else if (lewe instanceof PoleŻywieniowe && ((PoleŻywieniowe) lewe).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńWspX(lewe.dajWspółrzędnaX());
            rob.zmieńWspY(lewe.dajWspółrzędnaY());
            ((PoleŻywieniowe) lewe).zresetujIleDoOdrośnięcia(parametry);
            if (parametry.dajIleRośnieJedzenie() != 0) {
                plansza.zmniejszŻywność();
            }
            rob.zwiększEnergię(parametry.dajIleDajeJedzenie());
        }
        else if (prawe instanceof PoleŻywieniowe && ((PoleŻywieniowe) prawe).dajIleDoOdrośnięcia() == 0) {
            rob.zmieńWspX(prawe.dajWspółrzędnaX());
            rob.zmieńWspY(prawe.dajWspółrzędnaY());
            ((PoleŻywieniowe) prawe).zresetujIleDoOdrośnięcia(parametry);
            if (parametry.dajIleRośnieJedzenie() != 0) {
                plansza.zmniejszŻywność();
            }
            rob.zwiększEnergię(parametry.dajIleDajeJedzenie());
        }
    }
}
