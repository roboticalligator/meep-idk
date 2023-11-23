package Shorts;

import java.util.Scanner;
import java.lang.Math;

class Short2 {
    // defining a class
    public static void main(String[] args) {
        worldCupStats();
        return;
    }

    public static void worldCupStats() {
        final int matchesPlayed = getNoOfMatches();
        final int goalsScored = getNoOfGoals();

        System.out.println("Goals per match = " + calculateGoalsPerMatch(matchesPlayed, goalsScored));
        System.out.println("Minutes per Goal = " + calculateMinsPerGoal(matchesPlayed, goalsScored));
    }

    public static int getNoOfMatches() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many matches have been played so far? ");

        return scanner.nextInt();
    }

    public static int getNoOfGoals() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many goals have been scored so far? ");

        return scanner.nextInt();
    }

    public static int floor(float number) {
        return ((int) number);
    }

    public static float roundTo1dp(float number) {
        return ((float) Math.round(number * 10) / 10);
    }

    public static int calculateGoalsPerMatch(float matchesPlayed, float goalsScored) {
        return floor(goalsScored / matchesPlayed);
    }

    public static float calculateMinsPerGoal(float matchesPlayed, float goalsScored) {
        final int matchMins = 90;
        return roundTo1dp((matchesPlayed * matchMins) / goalsScored);
    }
}
