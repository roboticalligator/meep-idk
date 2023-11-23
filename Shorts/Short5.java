import java.util.Scanner;
import java.lang.Math;

public class Short5 {

    public static void main (String[] args) {
        showResults();
    }

    public static boolean checkChars(String userInput) {
        // checks the users input
        boolean check = false;
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


    public static int[] getGrades () {
        // get user inputs for number of each grade
        String[] gradesList = {"A+", "A", "B", "C", "D", "F", "G"};
        int[] numberPerGrade = new int[7];
        for (int i = 0; i < 7; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("How many " + gradesList[i] + " grades did you get? ");
            String userInput = scanner.nextLine();
            while (checkChars(userInput) == false) {
                System.out.println("Invalid input. Please try again.");
                scanner = new Scanner(System.in);
                System.out.print("How many " + gradesList[i] + " grades did you get? ");
                userInput = scanner.nextLine();
            }
            numberPerGrade[i] = Integer.parseInt(userInput);
        }
        return numberPerGrade;
    }

    public static int[] gradeOrBetter (int[] numberPerGrade) {
        // calculates how many of each grade or better
        int[] values = new int[7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                values[i] = values[i] + numberPerGrade[j];
            }
        }
        return values;
    }

    public static int validateGrades (int[] gradesOrBetter) {
        // checks if the user inputted 8 grades or less
        int flag = 0;

        // for (int i = 0; i < grades.length; i++) {
        //     System.out.print(grades[i]);
        // }
        // System.out.println();
        // for (int i = 0; i < grades.length; i++) {
        //     System.out.print(gradesOrBetter[i]);
        // }
        // System.out.println();
        // System.out.println(gradesOrBetter[6]);

        if (gradesOrBetter[6] > 8) {
            System.out.println("Please only input 8 grades.");
            flag = gradesOrBetter[6];
        } else if (gradesOrBetter[6] == 8){
            flag = 8;
        }
        return flag;
    }

    public static String calculateFinalGrade () {

        /*  min grade combinations
            A+  A   B   C   D   F   G
        A*  8   0   0   0   0   0   0
        A++ 7   1   0   0   0   0   0
        A+  6   2   0   0   0   0   0   *
        A   0   6   2   0   0   0   0   *
        B   0   0   6   2   0   0   0   *
        C   0   0   0   6   2   0   0   *
        D   0   0   0   0   6   2   0   *
        F   0   0   0   0   6   0   2
        G   0   0   0   0   0   0   8
        Q   0   0   0   0   0   0   0
        */

        /*  min gradeOrBetter combinations
            A+  A   B   C   D   F   G
        A*  8   8   8   8   8   8   8
        A++ 7   8   8   8   8   8   8
        A+  6   8   8   8   8   8   8   *
        A   0   6   8   8   8   8   8   *
        B   0   0   6   8   8   8   8   *
        C   0   0   0   6   8   8   8   *
        D   0   0   0   0   6   8   8   *
        F   0   0   0   0   6   6   8
        G   0   0   0   0   0   0   8
        Q   0   0   0   0   0   0   0
        */

        int[] finalGrades = getGrades();
        int[] finalGradesOrBetter = gradeOrBetter(finalGrades);
        int validation = validateGrades(finalGradesOrBetter);
        // System.out.println(validation);
        while (validation > 8){
            finalGrades = getGrades();
            finalGradesOrBetter = gradeOrBetter(finalGrades);
            validation = validateGrades(finalGradesOrBetter);
        }

        String[] gradesList = {"A+", "A", "B", "C", "D", "F", "G"};
        String finalGrade = "";
        if (validation < 8) {
            finalGrade = "Q";
        } else if (finalGradesOrBetter[0] == 8) {
            finalGrade = "A*";
        } else if (finalGradesOrBetter[0] == 7 && finalGradesOrBetter[1] == 8) {
            finalGrade = "A++";
        } else if (finalGrades[6] == 8) {
            finalGrade = "G";
        } else if (finalGradesOrBetter[5] < 8 && finalGradesOrBetter[6] == 8) {
            finalGrade = "F";
        } else {
            for (int i = 5; i > 0; i--) {
                if (finalGradesOrBetter[i] == 8 && finalGradesOrBetter[i - 1] == 6) {
                    finalGrade = gradesList[i - 1];
                    return finalGrade;
                } else if (finalGradesOrBetter[i] - finalGradesOrBetter[i - 1] > 2) {
                    finalGrade = gradesList[i];
                    return finalGrade;
                }
            }
        }
        return finalGrade;
    }

    public static void showResults () {
        // prints the final grades message
        String finalGrade = calculateFinalGrade();
        System.out.println("You consistently gained a " + finalGrade + " grade or better.");
        System.out.println("Therefore you gained a " + finalGrade + " grade overall.");
    }
}
