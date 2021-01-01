package main.models;

import main.interfaces.Identifikabilan;

import java.io.Serializable;

public class Odgovor implements Serializable, Identifikabilan {
    private String odgovor;
    private boolean jeTacan;
    private int id;

    public Odgovor(){}

    public Odgovor(String odgovor, boolean jeTacan) {
        this.odgovor = odgovor;
        this.jeTacan = jeTacan;
    }

    public void setJeTacan(boolean jeTacan) {
        this.jeTacan = jeTacan;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public boolean getjeTacan() {
        return jeTacan;
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
        return "Odgovor{" +
                "odgovor='" + odgovor + '\'' +
                ", jeTacan=" + jeTacan +
                '}';
    }
}
