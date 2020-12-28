package CS101Projekat;


import java.util.ArrayList;

public class Igra {
    ArrayList<Pitanje> pitanja;
    Player igrac;

    Igra(){}

    Igra(ArrayList<Pitanje> pitanja, Player igrac){
        this.pitanja = pitanja;
        this.igrac = igrac;
        // Maybe clear console here?
    }

    public void setIgrac(Player igrac) {
        this.igrac = igrac;
    }

    public void setPitanja(ArrayList<Pitanje> pitanja) {
        this.pitanja = pitanja;
    }

    public Player getIgrac() {
        return igrac;
    }

    public ArrayList<Pitanje> getPitanja() {
        return pitanja;
    }

    @Override
    public String toString() {
        return "Igra{" +
                "pitanja=" + pitanja +
                ", igrac=" + igrac +
                '}';
    }
}
