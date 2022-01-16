package zad1;

public class Rob {
    private int energia;
    private int wiek;
    private char[] program;
    private int wspX;
    private int wspY;
    private Zwrot zwrot;

    public Rob(int energia, char[] program, int wspX, int wspY, Zwrot zwrot) {
        this.energia = energia;
        this.program = program;
        this.wspX = wspX;
        this.wspY = wspY;
        this.zwrot = zwrot;
        wiek = 0;
    }

    public int dajEnergia() {
        return energia;
    }

    public int dajWiek() {
        return wiek;
    }

    public char[] dajProgram() {
        return program;
    }

    // Robi stringa z tablicy przechowującej program roba (do wypisywania).
    public String jakiProgram() {
        return new String(program);
    }

    public int dajWspX() {
        return wspX;
    }

    public int dajWspY() {
        return wspY;
    }

    public Zwrot dajZwrot() {
        return zwrot;
    }

    // Zwraca nazwę kierunku, w jaki jest zwrócony rob (do wypisywania).
    public String jakiZwrot() {
        switch (zwrot) {
            case GÓRA:
                return "północ";
            case DÓŁ:
                return "południe";
            case LEWO:
                return "zachód";
            case PRAWO:
                return "wschód";
        }
        return "Ten rob nigdzie się nie patrzy :)";
    }

    public void zwiększEnergię(int a) {
        energia += a;
    }

    public void zmniejszEnergię(int a) {
        energia -= a;
    }

    public void zwiększWiek() {wiek++;}

    public void zmieńProgram(char[] program) {
        this.program = program;
    }

    public void zmieńWspX(int noweX) {
        wspX = noweX;
    }

    public void zmieńWspY(int noweY) {
        wspY = noweY;
    }

    public void zmieńZwrot(Zwrot zwrot) {
        this.zwrot = zwrot;
    }

    // Wykonuje cały program roba.
    public void wykonajProgram(Plansza plansza, Parametry parametry) {
        for (int i = 0; i < this.program.length; i++) {
            if (this.energia > 0) {
                switch (program[i]) {
                    case 'l':
                        Lewo.wykonaj(this);
                        break;
                    case 'p':
                        Prawo.wykonaj(this);
                        break;
                    case 'i':
                        Idź.wykonaj(plansza, this, parametry);
                        break;
                    case 'w':
                        Wąchaj.wykonaj(plansza, this);
                        break;
                    case 'j':
                        Jedz.wykonaj(plansza, this, parametry);
                        break;
                }
                this.energia--;
            }
        }
    }

    // Zwraca pole na północny-zachód od roba.
    public Pole leweGórne(Plansza plansza) {
        int wspPolaX = (wspX + plansza.dajRozmiarPlanszyX() - 1) % plansza.dajRozmiarPlanszyX();
        int wspPolaY = (wspY + plansza.dajRozmiarPlanszyY() - 1) % plansza.dajRozmiarPlanszyY();
        return plansza.dajPoleZPlanszy(wspPolaX, wspPolaY);
    }

    // Zwraca pole na północny-wschód od roba.
    public Pole praweGórne(Plansza plansza) {
        int wspPolaX = (wspX + plansza.dajRozmiarPlanszyX() + 1) % plansza.dajRozmiarPlanszyX();
        int wspPolaY = (wspY + plansza.dajRozmiarPlanszyY() - 1) % plansza.dajRozmiarPlanszyY();
        return plansza.dajPoleZPlanszy(wspPolaX, wspPolaY);
    }

    // Zwraca pole na południowy-zachód od roba.
    public Pole leweDolne(Plansza plansza) {
        int wspPolaX = (wspX + plansza.dajRozmiarPlanszyX() - 1) % plansza.dajRozmiarPlanszyX();
        int wspPolaY = (wspY + plansza.dajRozmiarPlanszyY() + 1) % plansza.dajRozmiarPlanszyY();
        return plansza.dajPoleZPlanszy(wspPolaX, wspPolaY);
    }

    // Zwraca pole na południowy-wschód od roba.
    public Pole praweDolne(Plansza plansza) {
        int wspPolaX = (wspX + plansza.dajRozmiarPlanszyX() + 1) % plansza.dajRozmiarPlanszyX();
        int wspPolaY = (wspY + plansza.dajRozmiarPlanszyY() + 1) % plansza.dajRozmiarPlanszyY();
        return plansza.dajPoleZPlanszy(wspPolaX, wspPolaY);
    }

    // Zwraca pole na północ od roba.
    public Pole górne(Plansza plansza) {
        int wspPolaX = wspX;
        int wspPolaY = (wspY + plansza.dajRozmiarPlanszyY() - 1) % plansza.dajRozmiarPlanszyY();
        return plansza.dajPoleZPlanszy(wspPolaX, wspPolaY);
    }

    // Zwraca pole na południe od roba.
    public Pole dolne(Plansza plansza) {
        int wspPolaX = wspX;
        int wspPolaY = (wspY + plansza.dajRozmiarPlanszyY() + 1) % plansza.dajRozmiarPlanszyY();
        return plansza.dajPoleZPlanszy(wspPolaX, wspPolaY);
    }

    // Zwraca pole na zachód od roba.
    public Pole lewe(Plansza plansza) {
        int wspPolaX = (wspX + plansza.dajRozmiarPlanszyX() - 1) % plansza.dajRozmiarPlanszyX();
        int wspPolaY = wspY;
        return plansza.dajPoleZPlanszy(wspPolaX, wspPolaY);
    }

    // Zwraca pole na wschód od roba.
    public Pole prawe(Plansza plansza) {
        int wspPolaX = (wspX + plansza.dajRozmiarPlanszyX() + 1) % plansza.dajRozmiarPlanszyX();
        int wspPolaY = wspY;
        return plansza.dajPoleZPlanszy(wspPolaX, wspPolaY);
    }
}
