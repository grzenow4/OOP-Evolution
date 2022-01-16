package zad1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Plansza {
    private int rozmiarPlanszyX;
    private int rozmiarPlanszyY;
    private int liczbaRobów;
    private int numerTury;
    private int ileŻywności;
    private Rob[] roby;
    private Pole[][] pola;

    public Plansza(File plansza, Parametry parametry) throws FileNotFoundException {
        Scanner scanner = new Scanner(plansza);
        rozmiarPlanszyX = 0;
        rozmiarPlanszyY = 0;
        if (scanner.hasNextLine()) {
            rozmiarPlanszyX = scanner.nextLine().length();
            rozmiarPlanszyY++;
        }
        while (scanner.hasNextLine()) {
            assert scanner.nextLine().length() == rozmiarPlanszyX : "Niepoprawne wymiary planszy";
            rozmiarPlanszyY++;
        }
        assert rozmiarPlanszyX > 0 : "Niepoprawne wymiary planszy";
        scanner.close();
        pola = new Pole[rozmiarPlanszyX][rozmiarPlanszyY];
        ileŻywności = 0;
        scanner = new Scanner(plansza);
        for (int i = 0; i < rozmiarPlanszyY; i++) {
            String wiersz = scanner.nextLine();
            for (int j = 0; j < wiersz.length(); j++) {
                switch (wiersz.charAt(j)) {
                    case ' ':
                        pola[j][i] = new Pole(j, i);
                        break;
                    case 'x':
                        pola[j][i] = new PoleŻywieniowe(j, i);
                        ileŻywności++;
                        break;
                    default:
                        assert true : "Wczytano błędny znak";
                        break;
                }
            }
        }
        liczbaRobów = parametry.dajPoczIleRobów();
        numerTury = 0;
        roby = new Rob[liczbaRobów];
        for (int i = 0; i < liczbaRobów; i++) {
            Random p = new Random();
            int wspX = p.nextInt(rozmiarPlanszyX); // Losuje pierwszą współrzędną.
            int wspY = p.nextInt(rozmiarPlanszyY); // Losuje drugą współrzędną.
            int zwrot = p.nextInt(4); // Losuje zwrot.
            switch (zwrot) {
                case 0:
                    roby[i] = new Rob(parametry.dajPoczEnergia(), parametry.dajPoczProgram(), wspX, wspY, Zwrot.GÓRA);
                    break;
                case 1:
                    roby[i] = new Rob(parametry.dajPoczEnergia(), parametry.dajPoczProgram(), wspX, wspY, Zwrot.PRAWO);
                    break;
                case 2:
                    roby[i] = new Rob(parametry.dajPoczEnergia(), parametry.dajPoczProgram(), wspX, wspY, Zwrot.DÓŁ);
                    break;
                case 3:
                    roby[i] = new Rob(parametry.dajPoczEnergia(), parametry.dajPoczProgram(), wspX, wspY, Zwrot.LEWO);
                    break;
            }
        }
    }

    public int dajRozmiarPlanszyX() {
        return rozmiarPlanszyX;
    }

    public int dajRozmiarPlanszyY() {
        return rozmiarPlanszyY;
    }

    public Rob[] dajRoby() {
        return roby;
    }

    public Pole dajPoleZPlanszy(int wspX, int wspY) {
        return pola[wspX][wspY];
    }

    public void zmniejszŻywność() {
        ileŻywności--;
    }

    public void zwiększŻwyność() {
        ileŻywności++;
    }

    public void zmniejszRoby() {liczbaRobów--;}

    public void zwiększTury() {
        numerTury++;
    }

    public void dodajRoba(Rob rob) {
        liczbaRobów++;
        Rob[] noweRoby = new Rob[liczbaRobów];
        for (int i = 0; i < roby.length; i++) {
            noweRoby[i] = roby[i];
        }
        noweRoby[liczbaRobów - 1] = rob;
        roby = noweRoby;
    }

    // Usuwa wszystkie nulle z tablicy z robami.
    public void usuńRoby() {
        int i = 0;
        int j = roby.length - 1;
        while (i < j) {
            if (roby[i] == null) {
                while (roby[j] == null && i < j) {
                    j--;
                }
                if (i < j) {
                    roby[i] = roby[j];
                    roby[j] = null;
                    j--;
                }
            }
            i++;
        }
        Rob[] noweRoby = new Rob[liczbaRobów];
        for (int k = 0; k < liczbaRobów; k++) {
            noweRoby[k] = roby[k];
        }
        roby = noweRoby;
    }

    // Wypisuje podstawowe dane o stanie symulacji.
    public void wypiszStanSymulacji() {
        String dane = numerTury + ", rob: " + liczbaRobów + ", żyw: " + ileŻywności + ", prg: ";

        if (liczbaRobów == 0) {
            dane = dane + "0/0/0, energ: 0/0/0, wiek: 0/0/0";
            System.out.println(dane);
            return;
        }

        int[] programy = new int[roby.length];
        int[] energie = new int[roby.length];
        int[] lata = new int[roby.length];
        for (int i = 0; i < roby.length; i++) {
            programy[i] = roby[i].dajProgram().length;
            energie[i] = roby[i].dajEnergia();
            lata[i] = roby[i].dajWiek();
        }

        int minProg = roby[0].dajProgram().length;
        double śrProg = roby[0].dajProgram().length;
        int maxProg = roby[0].dajProgram().length;
        int minEnergia = roby[0].dajEnergia();
        int śrEnergia = roby[0].dajEnergia();
        int maxEnergia = roby[0].dajEnergia();
        int minWiek = roby[0].dajWiek();
        int śrWiek = roby[0].dajWiek();
        int maxWiek = roby[0].dajWiek();

        for (int i = 1; i < roby.length; i++) {
            if (programy[i] < minProg) {
                minProg = programy[i];
            }
            if (programy[i] > maxProg) {
                maxProg = programy[i];
            }
            śrProg += programy[i];

            if (energie[i] < minEnergia) {
                minEnergia = energie[i];
            }
            if (energie[i] > maxEnergia) {
                maxEnergia = energie[i];
            }
            śrEnergia += energie[i];

            if (lata[i] < minWiek) {
                minWiek = lata[i];
            }
            if (lata[i] > maxWiek) {
                maxWiek = lata[i];
            }
            śrWiek += lata[i];
        }

        śrProg /= liczbaRobów;
        śrEnergia /= liczbaRobów;
        śrWiek /= liczbaRobów;

        dane = dane + minProg + "/" + śrProg + "/" + maxProg + ", energ: "
                    + minEnergia + "/" + śrEnergia + "/" + maxEnergia + ", wiek: "
                    + minWiek + "/" + śrWiek + "/" + maxWiek;
        System.out.println(dane);
    }

    // Wypisuje dane na temat wszystkich robów.
    public void wypiszRoby() {
        System.out.println("Szczegółowe dane dotyczące robów:");
        for (int i = 0; i < liczbaRobów; i++) {
            String dane = "Rob nr " + i + ": współrzędne: (" + roby[i].dajWspX() + "," + roby[i].dajWspY() +
                                        ") zwrot: " + roby[i].jakiZwrot() + " energia: " + roby[i].dajEnergia() +
                                        " wiek: " + roby[i].dajWiek() + " wykonywany program: " + roby[i].jakiProgram();
            System.out.println(dane);
        }
    }
}
