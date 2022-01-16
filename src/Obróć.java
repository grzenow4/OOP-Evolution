package zad1;

public class Obróć {
    // Obraca roba w przeciwną stronę.
    public static void przeciwnie(Rob rob) {
        switch (rob.dajZwrot()) {
            case GÓRA:
                rob.zmieńZwrot(Zwrot.DÓŁ);
                break;
            case PRAWO:
                rob.zmieńZwrot(Zwrot.LEWO);
                break;
            case DÓŁ:
                rob.zmieńZwrot(Zwrot.GÓRA);
                break;
            case LEWO:
                rob.zmieńZwrot(Zwrot.PRAWO);
                break;
        }
    }
}
