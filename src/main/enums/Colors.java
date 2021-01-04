package main.enums;

public enum Colors {
    /**
     * Omogućava da u konzoli štampamo tekst u raznim bojama
     *
     * @see "https://stackoverflow.com/a/5762502/7453363"
     */
    YELLOW("\033[0;33m"),
    YELLOW_BOLD("\033[1;33m"),
    YELLOW_BOLD_BRIGHT("\033[1;93m"),
    RED("\033[0;31m"),
    RED_BOLD("\033[1;31m"),
    GREEN("\033[0;32m"),
    GREEN_BOLD("\033[1;32m"),
    RESET("\033[0m");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String val() {
        return this.color;
    }
}
