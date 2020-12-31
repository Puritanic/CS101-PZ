package CS101Projekat;

import java.util.ArrayList;
import java.util.Arrays;

public class TabelaRezultata {
    private ArrayList<Player> igraci;

    TabelaRezultata() {
    }

    TabelaRezultata(ArrayList<Player> igraci) {
        this.igraci = igraci;
    }

    private void sortirajIgracePremaPoenima() {
        Player[] listaIgraca = this.igraci.toArray(new Player[0]);

        System.out.println(Arrays.toString(listaIgraca));
        Arrays.sort(listaIgraca);
        System.out.println(Arrays.toString(listaIgraca));

        System.out.format("\033[1;93m%-11s%-11s%-11s\033[0m\n", "Pozicija", "Ime", "Broj Poena");
        for (int i = 0; i < listaIgraca.length; i++) {
            String[] listaStr = {i + ".", listaIgraca[i].getIme(), Integer.toString(listaIgraca[i].getBrojPoena())};
            System.out.format("%-11s%-11s%-11s\n", listaStr[0], listaStr[1], listaStr[2]);
        }
    }

    public void prikaziTabelu() {
        sortirajIgracePremaPoenima();
    }

    public ArrayList<Player> getIgraci() {
        return igraci;
    }

    public void setIgraci(ArrayList<Player> igraci) {
        this.igraci = igraci;
    }

    @Override
    public String toString() {
        return "TabelaRezultata{" +
                "igraci=" + igraci +
                '}';
    }


}
