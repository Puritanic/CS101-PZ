package CS101Projekat;


import java.util.ArrayList;
import java.util.Scanner;

public class Igra {
    ArrayList<Pitanje> pitanja;
    Player igrac;

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
                GameUtils.logYellow((i + 1) + ". " + odgovori[i].getOdgovor(), true);
            }

            GameUtils.logYellowB("------------------------------------", true);
            GameUtils.logYellowB("Tačan odgovor je pod rednim brojem: ", false);

            while (!unos.hasNextInt()) {
                GameUtils.logRed("Uneta vrednost mora biti ceo broj izmedju 1 i " + brojOdgovora + ". Pokušajte ponovo: ", true);
                unos.next();
            }

            int odgovor = unos.nextInt();
            System.out.println("Odgovor: " + odgovor);
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
