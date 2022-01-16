package zad1;

public class Lewo {
    // Obraca roba w lewo.
    public static void wykonaj(Rob rob) {
        switch (rob.dajZwrot()) {
            case GÓRA:
                rob.zmieńZwrot(Zwrot.LEWO);
                break;
            case PRAWO:
                rob.zmieńZwrot(Zwrot.GÓRA);
                break;
            case DÓŁ:
                rob.zmieńZwrot(Zwrot.PRAWO);
                break;
            case LEWO:
                rob.zmieńZwrot(Zwrot.DÓŁ);
                break;
        }
    }
}
