package zad1;
public class Idź {
    public static void wykonaj(Plansza plansza, Rob rob, Parametry parametry) {
        switch (rob.dajZwrot()) {
            case GÓRA:
                rob.zmieńWspY((rob.dajWspY() + plansza.dajRozmiarPlanszyY() - 1) % plansza.dajRozmiarPlanszyY());
                break;
            case PRAWO:
                rob.zmieńWspX((rob.dajWspX() + plansza.dajRozmiarPlanszyX() + 1) % plansza.dajRozmiarPlanszyX());
                break;
            case DÓŁ:
                rob.zmieńWspY((rob.dajWspY() + plansza.dajRozmiarPlanszyY() + 1) % plansza.dajRozmiarPlanszyY());
                break;
            case LEWO:
                rob.zmieńWspX((rob.dajWspX() + plansza.dajRozmiarPlanszyX() - 1) % plansza.dajRozmiarPlanszyX());
                break;
        }

        Pole nowePole = plansza.dajPoleZPlanszy(rob.dajWspX(), rob.dajWspY());

        if (nowePole instanceof PoleŻywieniowe && ((PoleŻywieniowe) nowePole).dajIleDoOdrośnięcia() == 0) {
            ((PoleŻywieniowe) nowePole).zresetujIleDoOdrośnięcia(parametry);
            if (parametry.dajIleRośnieJedzenie() != 0) {
                plansza.zmniejszŻywność();
            }
            rob.zwiększEnergię(parametry.dajIleDajeJedzenie());
        }
    }
}
