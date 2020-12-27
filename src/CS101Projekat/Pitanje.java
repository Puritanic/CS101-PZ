package CS101Projekat;

import java.io.Serializable;
import java.util.Arrays;

public class Pitanje implements Serializable {
    private String pitanje;
    private Odgovor[] odgovori;
    private int indeksTacnogOdgovora;

    Pitanje(){}

    Pitanje(String pitanje, Odgovor[] odgovori, int indeksTacnogOdgovora){
        this.pitanje = pitanje;
        this.odgovori = odgovori;
        this.indeksTacnogOdgovora = indeksTacnogOdgovora;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setOdgovori(Odgovor[] odgovori) {
        this.odgovori = odgovori;
    }

    public Odgovor[] getOdgovori() {
        return odgovori;
    }

    public void setIndeksTacnogOdgovora(int indeksTacnogOdgovora) {
        this.indeksTacnogOdgovora = indeksTacnogOdgovora;
    }

    public int getIndeksTacnogOdgovora() {
        return indeksTacnogOdgovora;
    }

    @Override
    public String toString() {
        return "Pitanje{" +
                "pitanje='" + pitanje + '\'' +
                ", odgovori=" + Arrays.toString(odgovori) +
                '}';
    }
}
