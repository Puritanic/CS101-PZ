package CS101Projekat;


import java.util.ArrayList;
import java.util.Scanner;

public class Igra {
    ArrayList<Pitanje> pitanja;
    Player igrac;
    private int brojTacnihOdgovora;

    Igra() {
    }

    Igra(ArrayList<Pitanje> pitanja, Player igrac) {
        this.pitanja = pitanja;
        this.igrac = igrac;
        LogUtils.clearConsole();
    }

    /**
     * Pokreće kviz, za svako pitanje štampamo ponudjene odgovore, i proveravamo da li je igrač odgovorio tačno nakon unosa
     * @return - boolean vrednost, koja označava da je igrač odlučio da igra ponovo
     */
    public boolean start() {
        Scanner unos = new Scanner(System.in);

        for (Pitanje pitanje : pitanja) {
            LogUtils.logYellowB("------------------------------------", true);
            LogUtils.logGreenB(pitanje.getPitanje().trim(), true);
            Odgovor[] odgovori = pitanje.getOdgovori();
            int brojOdgovora = odgovori.length;

            for (int i = 0; i < brojOdgovora; i++) {
                LogUtils.logYellowBB((i + 1) + ". ", false);
                LogUtils.logYellow(odgovori[i].getOdgovor().trim(), true);
            }

            LogUtils.logYellowB("------------------------------------", true);
            LogUtils.logYellowB("Tačan odgovor je pod rednim brojem...? ", false);

            int redniBrojOdgovora = 0;
            while (redniBrojOdgovora <= 0 || redniBrojOdgovora > brojOdgovora) {
                String greskaMsg = "Uneta vrednost mora biti ceo broj izmedju 1 i " + brojOdgovora + ". Pokušajte ponovo: ";
                while (!unos.hasNextInt()) {
                    LogUtils.logRed(greskaMsg, true);
                    unos.next();
                }
                redniBrojOdgovora = unos.nextInt();
                if (redniBrojOdgovora <= 0 || redniBrojOdgovora > brojOdgovora) {
                    LogUtils.logRed(greskaMsg, true);
                }
            }

            boolean odgovorJeTacan = odgovori[redniBrojOdgovora - 1].getjeTacan();
            if (odgovorJeTacan) {
                LogUtils.logGreenB("Odgovor je tačan.", true);
                brojTacnihOdgovora++;
            } else {
                LogUtils.logRedB("Odgovor nije tačan.", true);
            }
        }

        if (brojTacnihOdgovora < 5) {
            LogUtils.logRedB("Broj Tačnih odgovora: " + brojTacnihOdgovora + "/10", true);
        } else {
            LogUtils.logGreenB("Broj Tačnih odgovora: " + brojTacnihOdgovora + "/10", true);
        }

        igrac.setBrojPoena(igrac.getBrojPoena() + brojTacnihOdgovora * 10);
        igrac.setBrojZavrsenihIgara(igrac.getBrojZavrsenihIgara() + 1);

        LogUtils.logYellowB("------------------------------------", true);
        LogUtils.logGreenB("Pokreni igru ponovo? Nn/Dd - ", false);
        return Character.toUpperCase(unos.next().charAt(0)) == 'D';
    }

    public Player getIgrac() {
        return igrac;
    }

    public void setIgrac(Player igrac) {
        this.igrac = igrac;
    }

    public ArrayList<Pitanje> getPitanja() {
        return pitanja;
    }

    public void setPitanja(ArrayList<Pitanje> pitanja) {
        this.pitanja = pitanja;
    }

    @Override
    public String toString() {
        return "Igra{" +
                "pitanja=" + pitanja +
                ", igrac=" + igrac +
                '}';
    }
}
