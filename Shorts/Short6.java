import java.util.Scanner;
import java.util.ArrayList;

public class Short6 {
    public static void main (String[] args) {
        // calls the methods needed for output
        // System.out.print(checkChars("XXX"));
        showLapData(getLapTimes());
    }

    public static boolean checkChars(String userInput) {
        // checks the users input
        boolean check = false;

        if (userInput.equals("XXX")) {
            return true;
        } else {
            for (int i = 0; i < userInput.length(); i++) {
                char character = userInput.charAt(i);
                if (character >= '0' && character <= '9') {
                    check = true;
                } else {
                    return false;
                }
            }
            return check;
        }
    }

    public static ArrayList<Integer> getLapTimes() {
        // method to get the lap times
        ArrayList<Integer> lapTimes = new ArrayList<Integer>();
        int flag = 0;
        int i = 1;

        while (flag == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("What was lap time " + i + " (in s)? ");
            String userInput = scanner.nextLine();

            while (!checkChars(userInput)) {
                    scanner = new Scanner(System.in);
                    System.out.print("What was lap time " + i + " (in s)? ");
                    userInput = scanner.nextLine();
            }

            if (userInput.equals("XXX")) {
                i = 0;
                flag++;
            } else {
                lapTimes.add(Integer.parseInt(userInput));
            }

            if (i >= 2) {
                int difference = lapTimes.get(lapTimes.size() - 1) - lapTimes.get(lapTimes.size() - 2);
                if (difference < 0) {
                    difference = difference * (-1);
                    System.out.println("Difference " + difference + " seconds.");
                } else {
                    System.out.println("Difference " + difference + " seconds.");
                }
            }

            i++;
        }
        return lapTimes;
    }

    public static void showLapData(ArrayList<Integer> lapTimes) {
        // displays the lap data based on the user inputs (from calling the getLapTimes method)
        int totalTime = 0;
        for (int j = 0; j < lapTimes.size(); j++) {
            totalTime += (int) lapTimes.get(j);
        }
        System.out.println("You did " + lapTimes.size() + " laps. Your total time today was " + totalTime + "s.");
    }
}