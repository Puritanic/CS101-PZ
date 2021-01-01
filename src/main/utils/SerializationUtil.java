package main.utils;

import java.io.*;
import java.util.ArrayList;

/**
 * U zavisnosti od prosledjenog tipa, vrši serijalizaciju ili deserijalizaciju objekata u/iz eksternig fajlova
 *
 * @param <T> Player ili Pitanje klasa
 */
public class SerializationUtil<T> {
    /**
     * @param lista    ArrayList<Pitanje> ili ArrayList<Player>
     * @param imeFajla ime fajla u kome će objekti biti serijalizovani
     */
    public void serializeList(ArrayList<T> lista, String imeFajla) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(imeFajla)));
            try {
                for (T obj : lista) {
                    output.writeObject(obj);
                }
            } catch (IOException ex) {
                System.out.println("Greška pri pisanju objekata.");
                ex.printStackTrace();
            }
            output.close();
        } catch (IOException ex) {
            System.out.println("Greška pri serijalizaciji fajla " + imeFajla + " !");
            ex.printStackTrace();
        }
    }

    /**
     * @param imeFajla ime fajla iz koga čitamo objekte
     * @return listu objekata kastovanih u <T> klasu
     */
    public ArrayList<T> deserializeList(String imeFajla) {
        ArrayList<T> list = new ArrayList<>();
        boolean fajlPostoji = new File(imeFajla).exists();

        if (!fajlPostoji) {
            System.out.println("Fajl " + imeFajla + " ne postoji!");
            return list;
        }

        try {
            ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(imeFajla)));
            try {
                while (true) {
                    T obj = (T) input.readObject();
                    list.add(obj);
                }
            } catch (EOFException ex) {
                System.out.println("Fajl " + imeFajla + " je učitan!");
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Greška pri učitavanju objekata.");
                ex.printStackTrace();
            }
            input.close();
        } catch (IOException ex) {
            System.out.println("Greška pri deserijalizaciji fajla " + imeFajla + " !");
            ex.printStackTrace();
        }

        return list;
    }
}
