package CS101Projekat;

import java.io.Serializable;
import java.util.Random;

public class Player extends Osoba implements Serializable {
    private int brojPoena;
    private final int id;

    private int generisiID(){
       return new Random().nextInt(10000);
    }

    /**
     * Kreira Player klasu za novog igrača, u ovom slučaju nemamo ime
     * broj poena je podrazumevano 0, i generišemo novi id.
     */
    Player(){
        brojPoena = 0;
        id =  generisiID();
    }

    /**
     * Kreira Player klasu za novog igrača, u ovom slučaju imamo samo ime
     * broj poena je podrazumevano 0, i generišemo novi id.
     * @param ime
     */
    Player(String ime){
        super(ime);
        brojPoena = 0;
        id =  generisiID();
    }

    /**
     * Kreira Player klasu za već postojećeg igrača. U ovom slučaju imamo ime, id i broj poena igrača
     * @param ime
     * @param brojPoena
     * @param id
     */
    Player(String ime, int brojPoena, int id){
        super(ime);
        this.brojPoena = brojPoena;
        this.id = id;
    }

    public int getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(int brojPoena) {
        this.brojPoena = brojPoena;
    }

    @Override
    public String toString() {
        return super.toString() +  "Player{" +
                "brojPoena=" + brojPoena +
                '}';
    }
}
