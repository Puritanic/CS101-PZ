package main.utils;

import main.models.Odgovor;
import main.models.Pitanje;
import main.models.Player;

import java.io.File;
import java.util.ArrayList;

public final class GameUtils {
    public static final String START = "start";
    public static final String RES = "res";
    public static final String EXIT = "exit";
    public static final String HELP = "help";

    private GameUtils() {
    }

    /**
     * Generiše listu pitanja i odgovora i nakon toga vraća ArrayList sa tim vrednostima
     *
     * @return lista pitanja sa odgovorima
     */
    private static ArrayList<Pitanje> generisiPitanjaIOdgovore() {
        ArrayList<Pitanje> listaPitanja = new ArrayList<>();

        kreirajPitanje(
                listaPitanja,
                "If you want your condition to depend upon two conditions BOTH being true, What is the proper notation to put between the two Boolean statements?",
                new Odgovor[]{new Odgovor("!", false), new Odgovor("||", false), new Odgovor("&&", true)},
                2
        );

        kreirajPitanje(
                listaPitanja,
                "Java keywords are written in lowercase as well as uppercase?",
                new Odgovor[]{new Odgovor("True", false), new Odgovor("False", true)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "What is the correct syntax for java main method?",
                new Odgovor[]{new Odgovor("public static void main(string[] args)", false), new Odgovor("public static void main()", false), new Odgovor("public void main(String[] args)", false), new Odgovor("none of the above", true)},
                3
        );

        kreirajPitanje(
                listaPitanja,
                "Choose the appropriate data type for this field: isSwimmer",
                new Odgovor[]{new Odgovor("double", false), new Odgovor("boolean", true), new Odgovor("string", false), new Odgovor("int", false)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "Choose the appropriate data type for this value: 5.5",
                new Odgovor[]{new Odgovor("int", false), new Odgovor("double", true), new Odgovor("string", false), new Odgovor("boolean", false)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "Object-Oriented Programming means ...",
                new Odgovor[]{new Odgovor("Being objective about what you develop", false), new Odgovor("Designing the application based on the objects discovered when analysing the problem", true), new Odgovor("Writing an algorithm before writing your program and having a test plan", false), new Odgovor("Writing a program composed of Java classes", false)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "A UML Association is",
                new Odgovor[]{new Odgovor("implemented as a Java attribute member", true), new Odgovor("implemented as a Java method", false), new Odgovor(" implemented as a Java Class", false)},
                0
        );

        kreirajPitanje(
                listaPitanja,
                "Which of the following is not a Java keyword?",
                new Odgovor[]{new Odgovor("static", false), new Odgovor("try", false), new Odgovor("Integer", true), new Odgovor("new", false)},
                2
        );

        kreirajPitanje(
                listaPitanja,
                "What is an assignment statement?",
                new Odgovor[]{new Odgovor(" Adding a number to an int", false), new Odgovor("Assigning a multiplication", false), new Odgovor("Assigning a value to a variable", true), new Odgovor("Assigning a name to a variable", false)},
                2
        );

        kreirajPitanje(
                listaPitanja,
                "Which is NOT a section of all types of loops?",
                new Odgovor[]{new Odgovor("Initialization", false), new Odgovor("Test statement", false), new Odgovor("The keyword while", true), new Odgovor("Loop body", false)},
                2
        );

        kreirajPitanje(
                listaPitanja,
                "Java runs on _______.",
                new Odgovor[]{new Odgovor("  Windows", false), new Odgovor(" Unix/Linux", false), new Odgovor(" Mac OS", false), new Odgovor("All of the above", true)},
                3
        );

        kreirajPitanje(
                listaPitanja,
                "What is the size of a Char in Java?",
                new Odgovor[]{new Odgovor("4 bits", false), new Odgovor("7 bits", false), new Odgovor("8 bits", false), new Odgovor("16 bits", true)},
                3
        );

        kreirajPitanje(
                listaPitanja,
                "Following code:\n  int a1 = 5; double a2 = (float)a1;\nwill result in:",
                new Odgovor[]{new Odgovor("Compilation Error", false), new Odgovor("Runtime Error", false), new Odgovor("No Error", true), new Odgovor("Runtime Exception", false)},
                2
        );

        kreirajPitanje(
                listaPitanja,
                "What is essential in making sure that your loop is not infinite?",
                new Odgovor[]{new Odgovor("That your Boolean statement will at some point be false", false), new Odgovor(" That there is a Boolean statement somewhere in your code", false), new Odgovor(" That your Boolean statement will at some point be true", false), new Odgovor(" All of the choices", true)},
                3
        );

        kreirajPitanje(
                listaPitanja,
                "What is the default value of the local variables?",
                new Odgovor[]{new Odgovor("null", false), new Odgovor("0", false), new Odgovor("depends on data type", false), new Odgovor("no default value for local variables", true)},
                3
        );

        kreirajPitanje(
                listaPitanja,
                "Can you compare a boolean to an integer",
                new Odgovor[]{new Odgovor("Yes", false), new Odgovor("No", true)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "Is there is naming convention that variable name must be start with capital letter?",
                new Odgovor[]{new Odgovor("Yes", false), new Odgovor("No", true)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "Can you save the java source file without any name?",
                new Odgovor[]{new Odgovor("Yes", true), new Odgovor("No", false)},
                0
        );

        kreirajPitanje(
                listaPitanja,
                "&& have higer precedence than &?",
                new Odgovor[]{new Odgovor("True", false), new Odgovor("False", true)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "What method is used to notify the operating system that a file is no longer needed?",
                new Odgovor[]{new Odgovor("quit()", false), new Odgovor("exit()", false), new Odgovor("flush()", false), new Odgovor("close()", true)},
                3
        );

        kreirajPitanje(
                listaPitanja,
                "What value is assigned to a reference value to show that there is no object?",
                new Odgovor[]{new Odgovor("0", false), new Odgovor("void", false), new Odgovor("null", true), new Odgovor("\"\"", false)},
                2
        );

        kreirajPitanje(
                listaPitanja,
                "What is said of an operator like \"+\" when it has several meanings depending on context?",
                new Odgovor[]{new Odgovor("overloaded", true), new Odgovor("overlorded", false), new Odgovor("overworked", false), new Odgovor("overlooked", false)},
                0
        );

        kreirajPitanje(
                listaPitanja,
                "String myString;\nWhat is the data type of myString?",
                new Odgovor[]{new Odgovor("String", true), new Odgovor("reference to String", false), new Odgovor("null", false), new Odgovor("object", false)},
                0
        );

        kreirajPitanje(
                listaPitanja,
                "Which programming language is considered the first object-oriented programming language?",
                new Odgovor[]{new Odgovor("Smalltalk", false), new Odgovor("Simula", true)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "Abstraction hides complexity?",
                new Odgovor[]{new Odgovor("False", false), new Odgovor("True", true)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "What is the difference between aggregation and composition?",
                new Odgovor[]{new Odgovor("Aggregation represents strong relationship whereas composition represents weak relationship.", false), new Odgovor("Aggregation represents weak relationship whereas composition represents strong relationship.", true)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "The java compiler creates the default constructor of the class always?",
                new Odgovor[]{new Odgovor("False", true), new Odgovor("True", false)},
                0
        );

        kreirajPitanje(
                listaPitanja,
                "Inheritance provides ________________.",
                new Odgovor[]{new Odgovor("code reusability and represents IS-A relationship", true), new Odgovor("code reusability and represents HAS-A relationship", false)},
                0
        );

        kreirajPitanje(
                listaPitanja,
                "Can class can be transient?",
                new Odgovor[]{new Odgovor("Yes", false), new Odgovor("No", true)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "Class cannot be declared as _____",
                new Odgovor[]{new Odgovor("default", false), new Odgovor("private", true), new Odgovor("static", false)},
                1
        );

        kreirajPitanje(
                listaPitanja,
                "An abstract class can have non-abstract methods?",
                new Odgovor[]{new Odgovor("Yes", true), new Odgovor("No", false)},
                0
        );

        kreirajPitanje(
                listaPitanja,
                "How can you prevent a member variable from becoming serialized?",
                new Odgovor[]{new Odgovor("By marking it private", false), new Odgovor("By marking it volatile", false), new Odgovor("By marking it transient", true), new Odgovor("You can't", false)},
                2
        );

        kreirajPitanje(
                listaPitanja,
                "Methods that are marked protected can be called in any subclass of that class?",
                new Odgovor[]{new Odgovor("True", true), new Odgovor("False", false)},
                0
        );

        return listaPitanja;
    }

    private static void kreirajPitanje(ArrayList<Pitanje> listaPitanja, String pitanje, Odgovor[] odgovori, int idxOdgovora) {
        listaPitanja.add(new Pitanje(pitanje, odgovori, idxOdgovora));
    }

    public static boolean validirajKomandu(String komanda) {
        switch (komanda) {
            case START:
            case HELP:
            case RES:
            case EXIT:
                return true;
            default:
                System.out.print("Komanda nije dobra! Za spisak dozvoljenih komandi unesite ");
                LogUtils.logGreenB(HELP, true);
                System.out.print("Pokušajte ponovo: ");
                return false;
        }
    }

    public static void pocetnaInfoPoruka() {
        LogUtils.logGreen("Dobrodošli u Java kviz!", true);
        prikaziKomande();
    }

    public static void prikaziKomande() {
        LogUtils.logGreen("Za pregled rezultata unesite komandu ", false);
        LogUtils.logGreenB(RES, true);

        LogUtils.logGreen("Za početak igre unesite komandu ", false);
        LogUtils.logGreenB(START, true);

        LogUtils.logGreen("Za izlazak iz programa unesite komandu ", false);
        LogUtils.logGreenB(EXIT, true);

        LogUtils.logGreenB("Unesite komandu: ", false);
    }

    /**
     * Proverava da li postoji fajl sa pitanjima:
     * - ako ne postoji, generišemo novi fajl na osnovu liste pitanja koje imamo u programu
     * - ako postoji, učitavamo taj fajl, i listu pitanja na osnovu njegovog sadržaja
     *
     * @return lista pitanja
     */
    public static ArrayList<Pitanje> ucitajPitanja() {
        boolean fajlSaPitanjimaPostoji = new File("pitanja.dat").exists();
        SerializationUtil<Pitanje> su = new SerializationUtil<>();
        ArrayList<Pitanje> pitanja;

        if (fajlSaPitanjimaPostoji) {
            pitanja = su.deserializeList("pitanja.dat");
        } else {
            pitanja = generisiPitanjaIOdgovore();
            su.serializeList(pitanja, "pitanja.dat");
        }
        return pitanja;
    }

    /**
     * Pokušava učitavanje podataka o igračima sa eskternog fajla:
     * - u slučaju da eksterni fajl postoji, učitavamo objekte iz njega i kastujemo ih u klasu Player
     * - u slučaju da eksterni fajl ne postoji, vraćamo praznu listu
     *
     * @return sačuvani podaci o igračima koji su pokretali igru, ili prazna lista
     */
    public static ArrayList<Player> ucitajIgrace() {
        SerializationUtil<Player> su = new SerializationUtil<>();
        return su.deserializeList("players.dat");
    }

    /**
     * ubacuje podatke o trenutnom igraču u players.dat fajl
     * U slučaju da fajl ne postoji, kreiramo fajl i onda ubacujemo info
     * u suprotnom samo dodajemo još jedan unos (ako igrač sa ovim imenom već ne postoji?)
     *
     * @param igraci - Lista igrača
     * @param igrac  - trenutni igrač
     */
    public static void sacuvajInformacijeOIgracu(ArrayList<Player> igraci, Player igrac) {
        SerializationUtil<Player> su = new SerializationUtil<>();
        if (!igraci.contains(igrac)) {
            igraci.add(igrac);
        }
        su.serializeList(igraci, "players.dat");
    }
}
