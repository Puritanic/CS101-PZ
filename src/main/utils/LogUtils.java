package main.utils;

import main.enums.Colors;

public final class LogUtils {
    public static void logGreen(String poruka, boolean withNewLine) {
        System.out.print(Colors.GREEN.val() + poruka + Colors.RESET.val());
        if (withNewLine) System.out.println();
    }

    public static void logGreenB(String poruka, boolean withNewLine) {
        System.out.print(Colors.GREEN_BOLD.val() + poruka + Colors.RESET.val());
        if (withNewLine) System.out.println();
    }

    public static void logYellow(String poruka, boolean withNewLine) {
        System.out.print(Colors.YELLOW.val() + poruka + Colors.RESET.val());
        if (withNewLine) System.out.println();
    }

    public static void logYellowB(String poruka, boolean withNewLine) {
        System.out.print(Colors.YELLOW_BOLD.val() + poruka + Colors.RESET.val());
        if (withNewLine) System.out.println();
    }

    public static void logYellowBB(String poruka, boolean withNewLine) {
        System.out.print(Colors.YELLOW_BOLD_BRIGHT.val() + poruka + Colors.RESET.val());
        if (withNewLine) System.out.println();
    }

    public static void logRed(String poruka, boolean withNewLine) {
        System.out.print(Colors.RED.val() + poruka + Colors.RESET.val());
        if (withNewLine) System.out.println();
    }

    public static void logRedB(String poruka, boolean withNewLine) {
        System.out.print(Colors.RED_BOLD.val() + poruka + Colors.RESET.val());
        if (withNewLine) System.out.println();
    }
}
