package assignments.assignment1;

import BasicIO.*;
import java.util.Arrays;

public class Tournament {
    private final BasicForm form;   // Form to gather user input

    public Tournament() {
        form = new BasicForm();
        buildForm();             // Build the form with input fields
        form.accept();        // Wait for the user to input values and press accept

        // Retrieve values from the form
        int maxGames = form.readInt("maxGames");
        int matchesToSimulate = form.readInt("matchesToSimulate");
        double playWinChance = form.readDouble("playWinChance");
        boolean losersFirst = form.readBoolean("losersFirst");
        boolean earlyTermination = form.readBoolean("earlyTermination");

        // Validate that maxGames is an odd number
        while (maxGames % 2 == 0) {
            form.clear("maxGames");
            form.writeString("status", "Max games must be an odd number.");
            form.accept();
            maxGames = form.readInt("maxGames");
        }

        // Simulate the tournament
        int[][] matchResults = simulateTournament(matchesToSimulate, maxGames, playWinChance, losersFirst, earlyTermination);

        // Analyze and display the results
        analyzeResults(matchResults);

        logResults(matchResults, "tournament_results.txt", maxGames, playWinChance, losersFirst, earlyTermination);


        form.close();
    }

    private boolean simulateGame(double playWinChance, boolean isP1OnPlay) {
        return Math.random() < (isP1OnPlay ? playWinChance : 1 - playWinChance);
    }

    // Method to simulate an individual match
    public int[] simulateMatch(int maxGames, double playWinChance, boolean losersFirst, boolean earlyTermination) {
        int gamesNeededToWin = (maxGames / 2) + 1; // Best N of M
        int[] match = new int[maxGames + 1]; // Last entry is the winner, rest are game results

        int gamesWonByP1 = 0;
        int gamesWonByP2 = 0;
        boolean isP1OnPlay = true; // Player 1 starts 'on the play'

        for (int game = 0; game < maxGames; game++) {
            // Simulate a game
            boolean p1Wins = simulateGame(playWinChance, isP1OnPlay);
            match[game] = p1Wins ? 1 : 2;

            if (p1Wins) {
                gamesWonByP1++;
            } else {
                gamesWonByP2++;
            }

            // Early termination: stop match if one player wins two consecutive games
            if (earlyTermination && game < maxGames && match[game] == match[game + 1]) {
                break;
            }

            // Determine who is 'on the play' for the next game
            if (losersFirst) {
                isP1OnPlay = !p1Wins;
            } else {
                isP1OnPlay = !isP1OnPlay;
            }

            // Stop if someone has already won enough games
            if (gamesWonByP1 == gamesNeededToWin || gamesWonByP2 == gamesNeededToWin) {
                break;
            }
        }

        // Determine the overall winner of the match
        match[maxGames] = gamesWonByP1 > gamesWonByP2 ? 1 : 2;
        System.out.println(Arrays.toString(match));
        return match;
    }

    public int[][] simulateTournament(int numMatches, int maxGames, double playWinChance, boolean losersFirst, boolean earlyTermination){
        int[][] matchResults = new int[numMatches][maxGames];

        for(int i = 0; i < numMatches; i++){
            matchResults[i] = simulateMatch(maxGames, playWinChance, losersFirst, earlyTermination);
        }

        return matchResults;
    }

    // Method to set up the form fields
    private void buildForm() {
        form.setTitle("Tournament Simulation");

        // Adding fields to the form
        form.addTextField("maxGames", "Max Games (M) - Odd number", 5, 10, 10);
        form.addTextField("matchesToSimulate", "Number of Matches to Simulate", 5, 10, 40);
        form.addTextField("playWinChance", "Win Probability for 'On the Play' Player (0 to 1)", 5, 10, 70);

        form.addCheckBox("losersFirst", "'Losers First' Rule?", 10, 100);
        form.addCheckBox("earlyTermination", "Enable Early Termination?", 10, 130);

        form.addTextField("status", "Status", 30, 10, 190);
        form.setEditable("status", false); // Status field for validation errors or completion
    }

    // Method to analyze the results of the tournament
    public void analyzeResults(int[][] matchResults) {
        int matchesWonByP1 = 0;
        int totalGamesPlayed = 0;
        int gamesWonOnPlay = 0;

        for (int[] match : matchResults) {
            if (match[match.length - 1] == 1) {
                matchesWonByP1++;
            }
            for (int i = 0; i < match.length - 1 && match[i] != 0; i++) {
                totalGamesPlayed++;
                if(i != match.length - 1){
                    if (i % 2 == 1 && match[i] == 1) {
                        gamesWonOnPlay++;
                    } else if (i % 2 == 0 && match[i] == 2) {
                        gamesWonOnPlay++;
                    }
                }
            }
        }

        double proportionMatchesP1 = (double) matchesWonByP1 / matchResults.length;
        double averageMatchLength = (double) totalGamesPlayed / matchResults.length;
        double proportionGamesOnPlayWon = (double) gamesWonOnPlay / totalGamesPlayed;

        System.out.println("Tournament Summary:");
        System.out.println("Total matches simulated: " + matchResults.length);
        System.out.println("Proportion of matches won by 'on the play' player: " + proportionMatchesP1);
        System.out.println("Average match length: " + averageMatchLength + " games");
        System.out.println("Proportion of games won by the 'on the play' player: " + proportionGamesOnPlayWon);
    }

    public void logResults(int[][] matchResults, String filename, int maxGames, double playWinChance, boolean losersFirst, boolean earlyTermination) {
        ASCIIOutputFile output = new ASCIIOutputFile(filename);

        output.writeLine("Tournament Parameters:");
        output.writeLine("Max Games (M): " + maxGames);
        output.writeLine("Play Win Chance: " + playWinChance);
        output.writeLine("Losers First: " + losersFirst);
        output.writeLine("Early Termination: " + earlyTermination);

        int matchesWonByP1 = 0;
        int totalGamesPlayed = 0;
        int gamesWonOnPlay = 0;

        for (int[] match : matchResults) {
            if (match[0] == 1) {
                matchesWonByP1++;
            }
            for (int i = 1; i < match.length && match[i] != 0; i++) {
                totalGamesPlayed++;
                if (i % 2 == 1 && match[i] == 1) {
                    gamesWonOnPlay++;
                } else if (i % 2 == 0 && match[i] == 2) {
                    gamesWonOnPlay++;
                }
            }
        }

        double proportionMatchesP1 = (double) matchesWonByP1 / matchResults.length;
        double averageMatchLength = (double) totalGamesPlayed / matchResults.length;
        double proportionGamesOnPlayWon = (double) gamesWonOnPlay / totalGamesPlayed;

        output.writeLine("Proportion of matches won by Player 1: " + proportionMatchesP1);
        output.writeLine("Average match length: " + averageMatchLength);
        output.writeLine("Proportion of games won by the 'on the play' player: " + proportionGamesOnPlayWon);

        for (int[] match : matchResults) {
            for (int game : match) {
                if (game != 0) output.writeInt(game);
                else output.writeString("-");

                output.writeString(" ");
            }
            output.writeLine("\n");
        }

        output.close();
    }

    public static void main(String[] args) {Tournament t = new Tournament();}
}