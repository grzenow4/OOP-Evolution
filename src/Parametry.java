package zad1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parametry {
    private int ileTur;
    private int poczIleRobów;
    private char[] poczProgram;
    private int poczEnergia;
    private int ileDajeJedzenie;
    private int ileRośnieJedzenie;
    private int kosztTury;
    private double prPowielenia;
    private double ułamekEnergiiRodzica;
    private int limitPowielania;
    private double prUsunięciaInstr;
    private double prDodaniaInstr;
    private double prZmianyInstr;
    private char[] spisInstr;
    private int coIleWypisz;

    public Parametry(File parametry) throws FileNotFoundException {
        // Zmieni boola na true jeśli dany parametr zostanie wczytany.
        boolean czyIleTur = false;
        boolean czyPoczIleRobów = false;
        boolean czyPoczProgram = false;
        boolean czyPoczEnergia = false;
        boolean czyIleDajeJedzenie = false;
        boolean czyIleRośnieJedzenie = false;
        boolean czyKosztTury = false;
        boolean czyPrPowielenia = false;
        boolean czyUłamekEnergiiRodzica = false;
        boolean czyLimitPowielania = false;
        boolean czyPrUsunięciaInstr = false;
        boolean czyPrDodaniaInstr = false;
        boolean czyPrZmianyInstr = false;
        boolean czySpisInstr = false;
        boolean czyCoIleWypisz = false;
        Scanner scanner = new Scanner(parametry);
        while (scanner.hasNextLine()) {
            switch (scanner.next()) {
                case "ile_tur":
                    assert !czyIleTur : "Parametr podany podwójnie";
                    ileTur = scanner.nextInt();
                    czyIleTur = true;
                    break;
                case "pocz_ile_robów":
                    assert !czyPoczIleRobów : "Parametr podany podwójnie";
                    poczIleRobów = scanner.nextInt();
                    czyPoczIleRobów = true;
                    break;
                case "pocz_progr":
                    assert !czyPoczProgram : "Parametr podany podwójnie";
                    String string1 = scanner.next();
                    char[] program = new char[string1.length()];
                    for (int i = 0; i < string1.length(); i++) {
                        switch (string1.charAt(i)) {
                            case 'l':
                                program[i] = 'l';
                                break;
                            case 'p':
                                program[i] = 'p';
                                break;
                            case 'i':
                                program[i] = 'i';
                                break;
                            case 'w':
                                program[i] = 'w';
                                break;
                            case 'j':
                                program[i] = 'j';
                                break;
                            default:
                                assert true : "Błędny znak";
                                break;
                        }
                    }
                    poczProgram = program;
                    czyPoczProgram = true;
                    break;
                case "pocz_energia":
                    assert !czyPoczEnergia : "Parametr podany podwójnie";
                    poczEnergia = scanner.nextInt();
                    czyPoczEnergia = true;
                    break;
                case "ile_daje_jedzenie":
                    assert !czyIleDajeJedzenie : "Parametr podany podwójnie";
                    ileDajeJedzenie = scanner.nextInt();
                    czyIleDajeJedzenie = true;
                    break;
                case "ile_rośnie_jedzenie":
                    assert !czyIleRośnieJedzenie : "Parametr podany podwójnie";
                    ileRośnieJedzenie = scanner.nextInt();
                    czyIleRośnieJedzenie = true;
                    break;
                case "koszt_tury":
                    assert !czyKosztTury : "Parametr podany podwójnie";
                    kosztTury = scanner.nextInt();
                    czyKosztTury = true;
                    break;
                case "pr_powielenia":
                    assert !czyPrPowielenia : "Parametr podany podwójnie";
                    prPowielenia = Double.parseDouble(scanner.next());
                    czyPrPowielenia = true;
                    break;
                case "ułamek_energii_rodzica":
                    assert !czyUłamekEnergiiRodzica : "Parametr podany podwójnie";
                    ułamekEnergiiRodzica = Double.parseDouble(scanner.next());
                    czyUłamekEnergiiRodzica = true;
                    break;
                case "limit_powielania":
                    assert !czyLimitPowielania : "Parametr podany podwójnie";
                    limitPowielania = scanner.nextInt();
                    czyLimitPowielania = true;
                    break;
                case "pr_usunięcia_instr":
                    assert !czyPrUsunięciaInstr : "Parametr podany podwójnie";
                    prUsunięciaInstr = Double.parseDouble(scanner.next());
                    czyPrUsunięciaInstr = true;
                    break;
                case "pr_dodania_instr":
                    assert !czyPrDodaniaInstr : "Parametr podany podwójnie";
                    prDodaniaInstr = Double.parseDouble(scanner.next());
                    czyPrDodaniaInstr = true;
                    break;
                case "pr_zmiany_instr":
                    assert !czyPrZmianyInstr : "Parametr podany podwójnie";
                    prZmianyInstr = Double.parseDouble(scanner.next());
                    czyPrZmianyInstr = true;
                    break;
                case "spis_instr":
                    assert !czySpisInstr : "Parametr podany podwójnie";
                    String string2 = scanner.next();
                    spisInstr = new char[string2.length()];
                    for (int i = 0; i < string2.length(); i++) {
                        switch (string2.charAt(i)) {
                            case 'l':
                                spisInstr[i] = 'l';
                                break;
                            case 'p':
                                spisInstr[i] = 'p';
                                break;
                            case 'i':
                                spisInstr[i] = 'i';
                                break;
                            case 'w':
                                spisInstr[i] = 'w';
                                break;
                            case 'j':
                                spisInstr[i] = 'j';
                                break;
                            default:
                                assert true : "Błędny znak";
                                break;
                        }
                    }
                    czySpisInstr = true;
                    break;
                case "co_ile_wypisz":
                    assert !czyCoIleWypisz : "Parametr podany podwójnie";
                    coIleWypisz = scanner.nextInt();
                    czyCoIleWypisz = true;
                    break;
            }
        }
        scanner.close();
    }

    // Sprawdza czy znak c jest w tablicy tablica.
    private boolean czyJestZnak(char[] tablica, char c) {
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] == c) {
                return true;
            }
        }
        return false;
    }

    private boolean czyPoprawnyProgram() {
        for (int i = 0; i < poczProgram.length; i++) {
            if (!czyJestZnak(spisInstr, poczProgram[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean czyPoprawnySpis() {
        for (int i = 0; i < spisInstr.length; i++) {
            char c = spisInstr[i];
            if (c != 'l' && c != 'p' && c != 'i' && c != 'w' && c != 'j') {
                return false;
            }
        }
        return true;
    }

    public void sprawdźPoprawność() {
        assert ileTur > 0 : "Niepoprawne parametry";
        assert poczIleRobów > 0 : "Niepoprawne parametry";
        assert czyPoprawnyProgram() : "Niepoprawne parametry";
        assert poczEnergia >= 0 : "Niepoprawne parametry";
        assert ileDajeJedzenie > 0 : "Niepoprawne parametry";
        assert ileRośnieJedzenie > 0 : "Niepoprawne parametry";
        assert kosztTury >= 0 : "Niepoprawne parametry";
        assert (prPowielenia >= 0 && prPowielenia <= 1) : "Niepoprawne parametry";
        assert (ułamekEnergiiRodzica > 0 && ułamekEnergiiRodzica < 1) : "Niepoprawne parametry";
        assert limitPowielania > 0 : "Niepoprawne parametry";
        assert (prUsunięciaInstr >= 0 && prUsunięciaInstr <= 1) : "Niepoprawne parametry";
        assert (prDodaniaInstr >= 0 && prDodaniaInstr <= 1) : "Niepoprawne parametry";
        assert (prZmianyInstr >= 0 && prZmianyInstr <= 1) : "Niepoprawne parametry";
        assert czyPoprawnySpis();
        assert coIleWypisz > 0 : "Niepoprawne parametry";
    }

    public int dajIleTur() {
        return ileTur;
    }

    public int dajPoczIleRobów() {
        return poczIleRobów;
    }

    public char[] dajPoczProgram() {
        return poczProgram;
    }

    public int dajPoczEnergia() {
        return poczEnergia;
    }

    public int dajIleDajeJedzenie() {
        return ileDajeJedzenie;
    }

    public int dajIleRośnieJedzenie() {
        return ileRośnieJedzenie;
    }

    public int dajKosztTury() {
        return kosztTury;
    }

    public double dajPrPowielenia() {
        return prPowielenia;
    }

    public double dajUłamekEnergiiRodzica() {
        return ułamekEnergiiRodzica;
    }

    public int dajLimitPowielania() {
        return limitPowielania;
    }

    public double dajPrUsunięciaInstr() {
        return prUsunięciaInstr;
    }

    public double dajPrDodaniaInstr() {
        return prDodaniaInstr;
    }

    public double dajPrZmianyInstr() {
        return prZmianyInstr;
    }

    public char[] dajSpisInstr() {
        return spisInstr;
    }

    public int dajCoIleWypisz() {
        return coIleWypisz;
    }
}
