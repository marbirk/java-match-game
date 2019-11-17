package com.company;

public final class Game {
    private static final int matchesTotal = 17;
    private static int matchCount;
    private static int countOfDrawedMatchesFromUser;

    static {
        matchCount = matchesTotal;
        countOfDrawedMatchesFromUser = 0;
    }

    public static void start() {
        Introduction.show();

        while (true) {
            switch (Player.activePlayer) {
                case "computer":
                    displayMatchCount();
                    displayComputerActionIntroduction();
                    computerAction();
                    checkForAWinner();
                    Player.setActivePlayer("user");
                case "user":
                    displayMatchCount();
                    displayUserActionIntroduction();
                    userAction();
                    displayUserActionSummary();
                    checkForAWinner();
                    Player.setActivePlayer("computer");
            }
        }
    }

    private static void displayMatchCount() {
        Text.displayInLine("Number of matches on table: " + Helper.toString(getMatchCount()));
    }

    private static int getMatchCount() {
        return matchCount;
    }

    private static void displayComputerActionIntroduction() {
        Text.displayInLine("The computer made a move!");
    }

    /**
     * Method: computerAction
     * Strategy: Magical win formula: 4 - y
     * Source: http://www.imn.htwk-leipzig.de/~jahn/Cprog/Alg_Inf_Jahr_pdf/streichholzspiel.pdf
     */
    private static void computerAction() {
        drawMatch(4 - countOfDrawedMatchesFromUser);
    }

    private static void checkForAWinner() {
        if (isOnlyOneMatchLeft()) {
            displayMatchCount();
            Text.displayInLine("There is only one match left! You loose!");
            stop();
        }
    }

    private static boolean isOnlyOneMatchLeft() {
        return matchCount == 1;
    }

    private static void stop() {
        System.exit(0);
    }

    private static void displayUserActionIntroduction() {
        Text.displayInLine("It's your turn, " + User.userName + "! You can draw 1-3 matches from the table.");
        Text.displayInLine("Please select 1, 2 or 3!");
    }

    private static void userAction() {
        while (true) {
            String userInput = Text.read();
            int countOfDrawedMatches = Helper.parseInt(userInput);

            if (isUserInputAllowed(countOfDrawedMatches)) {
                setCountOfDrawedMatchesFromUser(countOfDrawedMatches);
                drawMatch(countOfDrawedMatches);
                return;
            }

            displayUserInputErrorMessage();
        }
    }

    private static void displayUserActionSummary() {
        String matchText = getCountOfDrawedMatchesFromUser() == 1 ? " match" : " matches";
        Text.displayInLine(
                "You took " +
                        getCountOfDrawedMatchesFromUser() +
                        matchText +
                        " from the table!");
        Text.displayReturn();
    }

    private static boolean isUserInputAllowed(int countOfDrawedMatches) {
        return countOfDrawedMatches <= 3;
    }

    private static void displayUserInputErrorMessage() {
        Text.displayInLine("This input is not allowed!");
        Text.displayInLine("Please try again!");
    }

    private static void drawMatch(int countOfDrawedMatches) {
        for (int i = 0; i < countOfDrawedMatches; i++) {
            decreaseMatchCount();
        }
    }

    private static void decreaseMatchCount() {
        matchCount--;
    }

    private static void setCountOfDrawedMatchesFromUser(int countOfDrawedMatches) {
        countOfDrawedMatchesFromUser = countOfDrawedMatches;
    }

    private static int getCountOfDrawedMatchesFromUser() {
        return countOfDrawedMatchesFromUser;
    }
}
