package CS101Projekat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Igra {
    public static void main(String[] args) throws IOException {
        pocetnaInfoPoruka();
        Scanner unos = new Scanner(System.in);
        try {
            // Učitaj pitanja i odgovore ako postoje
            boolean fajlSaPitanjimaPostoji = new File("pitanja.dat").exists();
            ArrayList<Pitanje> pitanja;
            if (fajlSaPitanjimaPostoji) {
                pitanja = GameUtils.ucitajFajlSaPitanjima();
            } else {
                pitanja = GameUtils.kreirajFajlSaPitanjima();
            }
            // TODO: Učitaj informacije o igračima ako postoje

            // Parsiranje unete komande
            String komanda = unos.next();
            while (!GameUtils.validirajKomandu(komanda)) {
                System.out.print("Komanda nije dobra! Pokušajte ponovo: ");
                komanda = unos.next();
            }

            System.out.println("Unos: " + komanda);
        } catch (IOException ex) {
            ex.getStackTrace();
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
    }
}
