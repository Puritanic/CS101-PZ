package main;

import main.models.Pitanje;
import main.models.Player;

import java.util.ArrayList;

public class Igra {
    private ArrayList<Pitanje> pitanja;
    private Player igrac;
    private int brojTacnihOdgovora;

    Igra() {
    }

    Igra(ArrayList<Pitanje> pitanja, Player igrac) {
        this.pitanja = pitanja;
        this.igrac = igrac;
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

    public int getBrojTacnihOdgovora() {
        return brojTacnihOdgovora;
    }

    public void setBrojTacnihOdgovora(int brojTacnihOdgovora) {
        this.brojTacnihOdgovora = brojTacnihOdgovora;
    }

    @Override
    public String toString() {
        return "Igra{" +
                "pitanja=" + pitanja +
                ", igrac=" + igrac +
                '}';
    }
}
