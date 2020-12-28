package CS101Projekat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner unos = new Scanner(System.in);
        // Učitaj pitanja i odgovore
        ArrayList<Pitanje> pitanja = ucitajPitanja();
        // Učitaj informacije o igračima ako postoje
        ArrayList<Player> igraci = ucitajIgrace();
        pocetnaInfoPoruka();
        // Parsiranje unete komande
        String komanda = unos.next();
        while (!GameUtils.validirajKomandu(komanda)) {
            System.out.print("Komanda nije dobra! Pokušajte ponovo: ");
            komanda = unos.next();
        }
        System.out.println("Unos: " + komanda);
        if (komanda.equals("start")){
            System.out.println("Neka igre počnu");
            // 1. Kreiraj igraca, ili unesi postojeće ime
            // ako igrac sa istim imenom vec postoji, pitamo korisnika da li je on taj igrac, a ako nije onda inkrementujemo broj igraca sa tim imenom
            // npr Jovan, Jovan 2, Jovan 3
            // 2. nakon ovoga pokrenemo klasu Igra, prosledimo listu od 10 pitanja i instancu igraca koju smo kreirali u koraku 1.
        } else if (komanda.equals("res")){
            System.out.println("Prikaži rezultate");
        } else if (komanda.equals("help")) {
            System.out.println("Prikaži help informacije");
        }
    }

    static void pocetnaInfoPoruka() {
        GameUtils.logGreen("Dobrodošli u Java kviz!");
        System.out.println();
        GameUtils.logGreen("Za pregled rezultata unesite komandu ");
        GameUtils.logGreenB("res");
        System.out.println();
        GameUtils.logGreen("Za početak igre unesite komandu ");
        GameUtils.logGreenB("start");
        System.out.println();
        GameUtils.logGreenB("Unesite komandu: ");
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
