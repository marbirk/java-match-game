package com.company;

import java.io.PrintStream;
import java.util.Scanner;

public final class Text {
    private static final PrintStream SystemOut = System.out;

    public static void displayInLine(String string) {
        SystemOut.println(string);
    }

    public static void displayReturn() {
        SystemOut.println();
    }

    public static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
