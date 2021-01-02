package main.enums;

public enum Komande {
    START("start"),
    EXIT("exit"),
    RES("res"),
    HELP("help");

    private final String komanda;

    Komande(String komanda) {
        this.komanda = komanda;
    }

    public String val() {
        return this.komanda;
    }
}
