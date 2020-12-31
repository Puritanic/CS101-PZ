package CS101Projekat;

import java.io.Serializable;

public abstract class Osoba implements Serializable {
    private String ime;

    Osoba() {
        this.ime = "Nepoznati igrač";
    }

    Osoba(String ime) {
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
