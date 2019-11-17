package com.company;

public final class Introduction {
    public static void show() {
        displayLogo();
        greeting();
        askForUserName();
        saveUserName();
        welcomeMessage();
    }

    private static void displayLogo() {
        Text.displayInLine(
                "  __  __       _       _        _____                      \n" +
                        " |  \\/  |     | |     | |      / ____|                     \n" +
                        " | \\  / | __ _| |_ ___| |__   | |  __  __ _ _ __ ___   ___ \n" +
                        " | |\\/| |/ _` | __/ __| '_ \\  | | |_ |/ _` | '_ ` _ \\ / _ \\\n" +
                        " | |  | | (_| | || (__| | | | | |__| | (_| | | | | | |  __/\n" +
                        " |_|  |_|\\__,_|\\__\\___|_| |_|  \\_____|\\__,_|_| |_| |_|\\___|\n"
        );
    }

    private static void greeting() {
        Text.displayInLine("Hello Stranger!");
    }

    private static void askForUserName() {
        Text.displayInLine("What's your name?");
    }

    private static void saveUserName() {
        String username = Text.read();
        User.setUserName(username);
    }

    private static void welcomeMessage() {
        Text.displayInLine("Welcome " + User.getUserName() + "! Nice to meet you :)");
        Text.displayReturn();
    }
}
