package main.abstracts;

import java.io.Serializable;

public abstract class Osoba implements Serializable {
    private String ime;

    public Osoba() {
        this.ime = "Nepoznati igrač";
    }

    public Osoba(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ime='" + ime + '\'' +
                '}';
    }
}
