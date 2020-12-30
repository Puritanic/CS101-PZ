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
        // Maybe clear console here?
    }

    public void pokreniIgru() {
        Scanner unos = new Scanner(System.in);

        for (Pitanje pitanje : pitanja) {
            GameUtils.logYellowB("------------------------------------", true);
            GameUtils.logGreenB(pitanje.getPitanje().trim(), true);
            Odgovor[] odgovori = pitanje.getOdgovori();
            int brojOdgovora = odgovori.length;

            for (int i = 0; i < brojOdgovora; i++) {
                GameUtils.logYellow((i + 1) + ". " + odgovori[i].getOdgovor().trim(), true);
            }

            GameUtils.logYellowB("------------------------------------", true);
            GameUtils.logYellowB("Tačan odgovor je pod rednim brojem: ", false);

            int redniBrojOdgovora = 0;
            while (redniBrojOdgovora <= 0 || redniBrojOdgovora > brojOdgovora) {
                String greskaMsg = "Uneta vrednost mora biti ceo broj izmedju 1 i " + brojOdgovora + ". Pokušajte ponovo: ";
                while (!unos.hasNextInt()) {
                    GameUtils.logRed(greskaMsg, true);
                    unos.next();
                }
                redniBrojOdgovora = unos.nextInt();
                if (redniBrojOdgovora <= 0 || redniBrojOdgovora > brojOdgovora) {
                    GameUtils.logRed(greskaMsg, true);
                }
            }

            boolean odgovorJeTacan = odgovori[redniBrojOdgovora - 1].getjeTacan();
            if (odgovorJeTacan) {
                GameUtils.logGreenB("Odgovor je tačan.", true);
                brojTacnihOdgovora++;
            } else {
                GameUtils.logRedB("Odgovor nije tačan.", true);
            }
        }

        if(brojTacnihOdgovora < 5){
            GameUtils.logRedB("Broj Tačnih odgovora: " + brojTacnihOdgovora + "/10", true);
        } else {
            GameUtils.logGreenB("Broj Tačnih odgovora: " + brojTacnihOdgovora + "/10", true);
        }
        unos.close();
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
