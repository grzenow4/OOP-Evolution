package zad1;

public class Prawo {
    // Obraca roba w prawo.
    public static void wykonaj(Rob rob) {
        switch (rob.dajZwrot()) {
            case GÓRA:
                rob.zmieńZwrot(Zwrot.PRAWO);
                break;
            case PRAWO:
                rob.zmieńZwrot(Zwrot.DÓŁ);
                break;
            case DÓŁ:
                rob.zmieńZwrot(Zwrot.LEWO);
                break;
            case LEWO:
                rob.zmieńZwrot(Zwrot.GÓRA);
                break;
        }
    }
}
