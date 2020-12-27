package CS101Projekat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Igra {
    public static void main(String[] args) throws IOException {
        try {
            boolean fajlSaPitanjimaPostoji = new File("pitanja.dat").exists();

            if (fajlSaPitanjimaPostoji) {
                ArrayList<Pitanje> pitanja = GameUtils.ucitajFajlSaPitanjima();
            } else {
                ArrayList<Pitanje> pitanja = GameUtils.kreirajFajlSaPitanjima();
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
}
