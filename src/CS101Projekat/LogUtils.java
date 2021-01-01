package CS101Projekat;

public class LogUtils {
    /**
     * Omogućava da u konzoli štampamo tekst u raznim bojama
     * @see "https://stackoverflow.com/a/5762502/7453363"
     */
    private static final String YELLOW = "\033[0;33m";
    private static final String YELLOW_BOLD = "\033[1;33m";
    private static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
    private static final String RED = "\033[0;31m";
    private static final String RED_BOLD = "\033[1;31m";
    private static final String GREEN = "\033[0;32m";
    private static final String GREEN_BOLD = "\033[1;32m";
    private static final String RESET = "\033[0m";  // Text Reset

    public static void logGreen(String poruka, boolean withNewLine) {
        System.out.print(GREEN + poruka + RESET);
        if (withNewLine) System.out.println();
    }

    public static void logGreenB(String poruka, boolean withNewLine) {
        System.out.print(GREEN_BOLD + poruka + RESET);
        if (withNewLine) System.out.println();
    }

    public static void logYellow(String poruka, boolean withNewLine) {
        System.out.print(YELLOW + poruka + RESET);
        if (withNewLine) System.out.println();
    }

    public static void logYellowB(String poruka, boolean withNewLine) {
        System.out.print(YELLOW_BOLD + poruka + RESET);
        if (withNewLine) System.out.println();
    }

    public static void logYellowBB(String poruka, boolean withNewLine) {
        System.out.print(YELLOW_BOLD_BRIGHT + poruka + RESET);
        if (withNewLine) System.out.println();
    }

    public static void logRed(String poruka, boolean withNewLine) {
        System.out.print(RED + poruka + RESET);
        if (withNewLine) System.out.println();
    }

    public static void logRedB(String poruka, boolean withNewLine) {
        System.out.print(RED_BOLD + poruka + RESET);
        if (withNewLine) System.out.println();
    }

    /**
     * Čisti konzolu, ali ne radi ako je terminal unutar IDE okruženja
     * @see "https://stackoverflow.com/a/17015039"
     */
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
