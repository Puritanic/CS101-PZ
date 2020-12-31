package CS101Projekat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Učitaj pitanja i odgovore
        ArrayList<Pitanje> pitanja = ucitajPitanja();
        // 2. Učitaj informacije o igračima ako postoje
        ArrayList<Player> igraci = ucitajIgrace();
        // 3. Prikaži početnu poruku
        pocetnaInfoPoruka();
        // 4. Pokreni Scanner i slušaj korisnički input
        Scanner unos = new Scanner(System.in);
        String komanda = unos.next();
        // 4a. Dozvoli unos samo postojećih komandi, start, res, i help
        while (!GameUtils.validirajKomandu(komanda)) {
            komanda = unos.next();
        }
        // 5. Obradi unetu komandu koja je validna
        switch (komanda) {
            case "start":
                // 5a. Kreiraj igraca
                Player igrac = pripremiIgru();
                // 5b. Pokreni igru
                pokreniIgru(igrac, pitanja);
                // Nakon završene igre sačuvaj informacije o igraču
                GameUtils.sacuvajInformacijeOIgracu(igraci, igrac);
                break;
            case "res":
                System.out.println("Prikaži rezultate");
                break;
            case "help":
                prikaziKomande();
                break;
            case "exit":
                break;
        }
        unos.close();
    }

    static Player pripremiIgru() {
        Scanner unos = new Scanner(System.in);
        LogUtils.logGreen("Unesite ime: ", false);
        String ime = unos.next();
        while (ime.length() < 2 || ime.length() > 10) {
            System.out.println("Ime igrača mora biti izmedju dva i 10 karaktera");
            ime = unos.next();
        }
        return new Player(ime);
    }

    static void pokreniIgru(Player igrac, ArrayList<Pitanje> pitanja) {
        boolean igrajPonovo;
        do {
            Collections.shuffle(pitanja);
            ArrayList<Pitanje> _pitanja = new ArrayList<>();
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
            igrajPonovo = igra.pokreniIgru();
        } while (igrajPonovo);
        System.out.println("Kraj programa!");
    }

    static void pocetnaInfoPoruka() {
        LogUtils.logGreen("Dobrodošli u Java kviz!", true);
        prikaziKomande();
    }

    static void prikaziKomande() {
        LogUtils.logGreen("Za pregled rezultata unesite komandu ", false);
        LogUtils.logGreenB("res", true);

        LogUtils.logGreen("Za početak igre unesite komandu ", false);
        LogUtils.logGreenB("start", true);

        LogUtils.logGreen("Za izlazak iz programa unesite komandu ", false);
        LogUtils.logGreenB("exit", true);

        LogUtils.logGreenB("Unesite komandu: ", false);
    }

    static ArrayList<Pitanje> ucitajPitanja() throws IOException {
        boolean fajlSaPitanjimaPostoji = new File("pitanja.dat").exists();
        ArrayList<Pitanje> pitanja;
        if (fajlSaPitanjimaPostoji) {
            pitanja = GameUtils.ucitajFajlSaPitanjima();
        } else {
            pitanja = GameUtils.kreirajFajlSaPitanjima();
        }
        return pitanja;
    }

    static ArrayList<Player> ucitajIgrace() {
        ArrayList<Player> igraci = new ArrayList<>();
        try {
            igraci = GameUtils.ucitajFajlSaIgracima();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return igraci;
    }
}
