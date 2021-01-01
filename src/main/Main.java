package main;

import main.models.Pitanje;
import main.models.Player;
import main.utils.GameUtils;

import java.io.IOException;
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
        do {
            // 4b. Dozvoli unos samo postojećih komandi, start, res, i help
            while (!GameUtils.validirajKomandu(komanda)) {
                komanda = unos.next();
            }
            // 5. Obradi unetu komandu koja je validna
            switch (komanda) {
                case "start":
                    // 6. Kreiraj igraca
                    Player igrac = Player.kreirajIgraca(igraci);
                    // 7. Pokreni igru
                    pokreniIgru(igrac, pitanja);
                    // 8. Nakon završene igre sačuvaj informacije o igraču
                    try {
                        GameUtils.sacuvajInformacijeOIgracu(igraci, igrac);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "res":
                    // 6a. Prikaži tabelu rezultata
                    TabelaRezultata tabelaRezultata = new TabelaRezultata(igraci);
                    tabelaRezultata.prikaziTabelu();
                    break;
                case "help":
                case "exit":
                    break;
            }
            GameUtils.prikaziKomande();
            komanda = unos.next();
        } while (!komanda.equals("exit"));

        unos.close();
    }

    /**
     * Priprema podatke za početak igre, i nakon toga pokreće igru
     * @param igrac - trenutni igrač
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
            igrajPonovo = igra.start();
        } while (igrajPonovo);
    }
}
