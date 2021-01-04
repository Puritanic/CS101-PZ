package main;

import main.models.Odgovor;
import main.models.Pitanje;
import main.models.Player;
import main.utils.GameUtils;
import main.utils.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Učitaj pitanja i odgovore
        ArrayList<Pitanje> pitanja = GameUtils.ucitajPitanja();
        // 2. Učitaj informacije o igračima ako postoje
        ArrayList<Player> igraci = GameUtils.ucitajIgrace();
        // 3. Prikaži početnu poruku
        GameUtils.pocetnaInfoPoruka();
        // 4. Pokreni Scanner i slušaj korisnički input
        Scanner unos = new Scanner(System.in);
        String komanda = unos.next();
        // 4a. Slušamo korisnički input dok ne dobijemo komandu "exit" nakon koje zatvaramo program
        mainLoop: do {
            // 4b. Dozvoli unos samo postojećih komandi, start, res, i help
            while (!GameUtils.validirajKomandu(komanda)) {
                komanda = unos.next();
            }
            // 5. Obradi unetu komandu koja je validna
            switch (komanda.toLowerCase()) {
                case GameUtils.START:
                    // 6. Kreiraj igraca
                    Player igrac = Player.kreirajIgraca(igraci);
                    // 7. Pokreni igru
                    pokreniIgru(igrac, pitanja);
                    // 8. Nakon završene igre sačuvaj informacije o igraču
                    GameUtils.sacuvajInformacijeOIgracu(igraci, igrac);
                    GameUtils.prikaziKomande();
                    break;
                case GameUtils.RES:
                    // 6a. Prikaži tabelu rezultata
                    TabelaRezultata tabelaRezultata = new TabelaRezultata(igraci);
                    tabelaRezultata.prikaziTabelu();
                    GameUtils.prikaziKomande();
                    break;
                case GameUtils.EXIT:
                    break mainLoop;
                case GameUtils.HELP:
                default:
                    GameUtils.prikaziKomande();
            }
            komanda = unos.next();
        } while (!komanda.equalsIgnoreCase(GameUtils.EXIT));
        unos.close();
    }

    /**
     * Priprema podatke za početak igre, i nakon toga pokreće igru
     *
     * @param igrac   - trenutni igrač
     * @param pitanja - lista svih pitanja
     */
    static void pokreniIgru(Player igrac, ArrayList<Pitanje> pitanja) {
        boolean igrajPonovo;
        do {
            // Pomešamo redosled pitanja svaki put, da igrač ne bi odgovarao na pitanja istim redosledom
            Collections.shuffle(pitanja);
            ArrayList<Pitanje> _pitanja = new ArrayList<>();
            // U igri koristimo samo prvih deset pitanja iz celokupne liste pitanja
            int counter = 0;
            for (Pitanje pitanje : pitanja) {
                if (counter < 10) {
                    _pitanja.add(pitanje);
                    counter++;
                } else {
                    break;
                }
            }
            Igra igra = new Igra(_pitanja, igrac);
            igrajPonovo = startKviz(igra);
        } while (igrajPonovo);
    }

    /**
     * Pokreće kviz, za svako pitanje štampamo ponudjene odgovore, i proveravamo da li je igrač odgovorio tačno nakon unosa
     *
     * @return - boolean vrednost, koja označava da je igrač odlučio da igra ponovo
     */
    public static boolean startKviz(Igra igra) {
        Scanner unos = new Scanner(System.in);

        for (Pitanje pitanje : igra.getPitanja()) {
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
                igra.setBrojTacnihOdgovora(igra.getBrojTacnihOdgovora() + 1);
            } else {
                LogUtils.logRedB("Odgovor nije tačan.", true);
            }
        }

        int brojTacnihOdgovora = igra.getBrojTacnihOdgovora();
        if (brojTacnihOdgovora < 5) {
            LogUtils.logRedB("Broj Tačnih odgovora: " + brojTacnihOdgovora + "/10", true);
        } else {
            LogUtils.logGreenB("Broj Tačnih odgovora: " + brojTacnihOdgovora + "/10", true);
        }

        Player igrac = igra.getIgrac();
        igrac.setBrojPoena(igrac.getBrojPoena() + brojTacnihOdgovora * 10);
        igrac.setBrojZavrsenihIgara(igrac.getBrojZavrsenihIgara() + 1);

        LogUtils.logYellowB("------------------------------------", true);
        LogUtils.logGreenB("Pokreni igru ponovo? Nn/Dd - ", false);
        return Character.toUpperCase(unos.next().charAt(0)) == 'D';
    }
}
