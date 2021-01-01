package main;

import main.models.Player;
import main.utils.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class TabelaRezultata {
    private Player[] igraci;

    public TabelaRezultata() {
    }

    public TabelaRezultata(ArrayList<Player> igraci) {
        this.igraci = sortirajIgracePremaPoenima(igraci);
    }

    /**
     * Sortira listu igrača prema osvojenim poenima, u opadajućem redosledu
     * @return sortirani niz igrača
     */
    private Player[] sortirajIgracePremaPoenima(ArrayList<Player> igraci) {
        Player[] listaIgraca = igraci.toArray(new Player[0]);
        // Sortiraj igrače prema broju poena, desc order
        Arrays.sort(listaIgraca);
        return listaIgraca;
    }

    /**
     * Štampa formatiranu listu igrača
     */
    public void prikaziTabelu() {
        System.out.format("\033[1;93m%-10s%-11s%-11s%-12s\033[0m\n", "Pozicija", "Ime", "Broj Poena", "Broj igara");

        if (igraci.length == 0){
            System.out.println();
            LogUtils.logGreenB(" Trenutno nema sačuvanih rezultata", true);
            System.out.println();
        } else {
            System.out.println();
            for (int i = 0; i < igraci.length; i++) {
                System.out.format("%-10s%-11s%-11s%-12s\n", i + ".", igraci[i].getIme(), igraci[i].getBrojPoena(),igraci[i].getBrojZavrsenihIgara() );
            }
            System.out.println();
        }

    }

    public Player[] getIgraci() {
        return igraci;
    }

    public void setIgraci(Player[] igraci) {
        this.igraci = igraci;
    }

    @Override
    public String toString() {
        return "TabelaRezultata{" +
                "igraci=" + Arrays.toString(igraci) +
                '}';
    }
}
