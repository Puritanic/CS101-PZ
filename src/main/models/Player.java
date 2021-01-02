package main.models;

import main.abstracts.Osoba;
import main.interfaces.Identifikabilan;
import main.utils.LogUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player extends Osoba implements Serializable, Comparable<Player>, Identifikabilan {
    private int id;
    private int brojPoena;
    private int brojZavrsenihIgara;

    /**
     * Kreira Player klasu za novog igrača, u ovom slučaju nemamo ime
     * broj poena je podrazumevano 0, i generišemo novi id.
     */
    public Player() {
        brojPoena = 0;
        id = generisiID();
    }

    /**
     * Kreira Player klasu za novog igrača, u ovom slučaju imamo samo ime
     * broj poena je podrazumevano 0, i generišemo novi id.
     *
     * @param ime ime igrača
     */
    public Player(String ime) {
        super(ime);
        brojPoena = 0;
        id = generisiID();
    }

    /**
     * Kreira Player klasu za već postojećeg igrača. U ovom slučaju imamo ime, id i broj poena igrača
     *
     * @param ime       ime igrača
     * @param brojPoena broj poena igrača
     * @param id        identifikacioni broj igrača
     */
    Player(String ime, int brojPoena, int id) {
        super(ime);
        this.brojPoena = brojPoena;
        this.id = id;
    }

    /**
     * @return novi igrač
     */
    public static Player kreirajIgraca(ArrayList<Player> igraci) {
        LogUtils.logGreen("Unesite ime: ", false);
        Scanner unos = new Scanner(System.in);
        String ime = unos.nextLine();
        while (ime.length() < 2 || ime.length() > 10) {
            System.out.println("Ime igrača mora biti izmedju dva i 10 karaktera");
            ime = unos.next();
        }
        // Proveri da li igrač već postoji
        if (igraci.size() > 0) {
            for (Player igrac : igraci) {
                if (igrac.getIme().equals(ime)) {
                    LogUtils.logGreen("Dobrodošli nazad ", false);
                    LogUtils.logGreenB(igrac.getIme(), true);
                    return igrac;
                }
            }
        }
        return new Player(ime);
    }

    private int generisiID() {
        return new Random().nextInt(10000);
    }

    public int getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(int brojPoena) {
        this.brojPoena = brojPoena;
    }

    public int getBrojZavrsenihIgara() {
        return brojZavrsenihIgara;
    }

    public void setBrojZavrsenihIgara(int brojZavrsenihIgara) {
        this.brojZavrsenihIgara = brojZavrsenihIgara;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", brojPoena=" + brojPoena +
                ", brojZavrsenihIgara=" + brojZavrsenihIgara +
                '}';
    }

    @Override
    public int compareTo(Player igrac) {
        if (this.brojPoena > igrac.getBrojPoena()) {
            return -1;
        } else if (this.brojPoena < igrac.getBrojPoena()) {
            return 1;
        }
        return 0;
    }
}
