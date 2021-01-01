package main.models;

import main.interfaces.Identifikabilan;

import java.io.Serializable;
import java.util.Arrays;

public class Pitanje implements Serializable, Identifikabilan {
    private String pitanje;
    private Odgovor[] odgovori;
    private int indeksTacnogOdgovora;
    private int id;

    public Pitanje() {
    }

    public Pitanje(String pitanje, Odgovor[] odgovori, int indeksTacnogOdgovora) {
        this.pitanje = pitanje;
        this.odgovori = odgovori;
        this.indeksTacnogOdgovora = indeksTacnogOdgovora;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public Odgovor[] getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(Odgovor[] odgovori) {
        this.odgovori = odgovori;
    }

    public int getIndeksTacnogOdgovora() {
        return indeksTacnogOdgovora;
    }

    public void setIndeksTacnogOdgovora(int indeksTacnogOdgovora) {
        this.indeksTacnogOdgovora = indeksTacnogOdgovora;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Pitanje{" +
                "pitanje='" + pitanje + '\'' +
                ", odgovori=" + Arrays.toString(odgovori) +
                '}';
    }
}
