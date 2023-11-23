package Short7;

import Short7.Candidate;
import java.util.Scanner; // imports for user inputs

public class Election {
    public static void main(String[] args) { // calls the method that runs the election (runElection)
        runElection();
    }

    public static String validateStrIn(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        int validation = 0;
        while (validation == 0) {
            if (userInput.length() > 0) {
                validation ++;
            } else {
                System.out.print(prompt);
                scanner = new Scanner(System.in);
                userInput = scanner.nextLine();
            }
        }

        return userInput;
    }

    public static int validateIntIn(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        int validation = 0;
        boolean check = true;
        while (validation == 0) {
            for (int i = 0; i < userInput.length(); i ++) {
                char userChar = userInput.charAt(i);
                if (userChar >= '0' && userChar <= '9') {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }

            if (!check) {
                System.out.println("Your input is not an integer within range.");
                System.out.print(prompt);
                scanner = new Scanner(System.in);
                userInput = scanner.nextLine();
            } else {
                validation ++;
            }
        }

        return Integer.parseInt(userInput);
    }

    public static void setCandidateName(Short7.Candidate candidate, int number) { // asks question based on if they're the first/second candidate
        if (number == 1) {
            candidate.name = validateStrIn("What is the name of the first candidate? ");
        } else {
            candidate.name = validateStrIn("What is the name of the second candidate? ");
        }
    } // sets candidate's name in candidate's record

    public static void setCandidateParty(Short7.Candidate candidate) {
        candidate.party = validateStrIn("What party did they stand for? ");
    } // sets candidate's party in candidate's record

    public static void setCandidateVotes(Short7.Candidate candidate) {
        candidate.votes = validateIntIn("How many votes did they gain? ");
    } // sets candidate's votes in candidate's record

    public static void calcWinner(Short7.Candidate c1, Short7.Candidate c2) {
        int difference;
        if (c1.won) { // calculates c1's majority and prints c1 winning message
            difference = c1.votes - c2.votes;
            System.out.println(c1.name + " of the " + c1.party + " is declared the winner with " + c1.votes + " votes.");
            System.out.println("They have a majority of " + difference + ".");
        } else if (c2.won) { // calculates c2's majority and prints c2 winning message
            difference = c2.votes - c1.votes;
            System.out.println(c2.name + " of the " + c2.party + " is declared the winner with " + c2.votes + " votes.");
            System.out.println("They have a majority of " + difference + ".");
        } else { // prints tie message
            System.out.println("Votes are tied. There will be another election.");
        }
    }

    public static void runElection() {
        Short7.Candidate candidate1 = new Candidate();
        Short7.Candidate candidate2 = new Candidate();

        setCandidateName(candidate1, 1); // setting candidate1's details by calling methods setCandidateName, setCandidateParty, setCandidateVotes
        setCandidateParty(candidate1);
        setCandidateVotes(candidate1);

        setCandidateName(candidate2, 2); // setting candidate2's details by calling methods setCandidateName, setCandidateParty, setCandidateVotes
        setCandidateParty(candidate2);
        setCandidateVotes(candidate2);

        if (candidate1.votes > candidate2.votes) {
            candidate1.won = true;
        } else if (candidate2.votes > candidate1.votes) {
            candidate2.won = true;
        } else {
            ;
        }

        calcWinner(candidate1, candidate2); // calculates the election winner with a call to method calcWinner
    }
}
