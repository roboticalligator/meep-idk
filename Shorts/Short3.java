import java.util.Scanner;
import java.lang.Math;

public class Short3 {
    public static void main(String[] args) {
        calculateFinalGrades();
    }

    public static void calculateFinalGrades() {
        // calls all the methods
        final String[] testGradesList = getGrades();
        System.out.println("Your grades were " + testGradesList[0] + " " + testGradesList[1] + " " + testGradesList[2]);
        System.out.println("Your grades were " + testGradesList[3] + " " + testGradesList[4] + " " + testGradesList[5]);
        System.out.print("Your final three test grades are Theory: " + getBestGrade(testGradesList[0], testGradesList[3]) + ", Dry Run: " + getBestGrade(testGradesList[1], testGradesList[4]) + ", Program: " + getBestGrade(testGradesList[2], testGradesList[5]));
    }

    public static String getBestGrade(String grade1, String grade2) {
        // gets best grade by converting the grades to numbers and taking the min value before converting back to a grade
        return convertOptionToGrade(Math.min(convertGradeToOption(grade1), convertGradeToOption(grade2)));
    }

    public static String convertOptionToGrade(int gradeOption) {
        // finds the equivalent grade to the option the user inputted
        if (gradeOption == 1) {
            return "A+";
        }
        else if (gradeOption == 2) {
            return "A";
        }
        else if (gradeOption == 3) {
            return "B";
        }
        else if (gradeOption == 4) {
            return "C";
        }
        else if (gradeOption == 5) {
            return "D";
        }
        else if (gradeOption == 6) {
            return "F";
        }
        else if (gradeOption == 7) {
            return "G";
        }
        else {
            return "The option you chose isn't available.";
        }
    }

    public static int convertGradeToOption(String grade) {
        // finds the numerical value for the grade so it is easier to compare
        if (grade == "A+") {
            return 1;
        }
        else if (grade == "A") {
            return 2;
        }
        else if (grade == "B") {
            return 3;
        }
        else if (grade == "C") {
            return 4;
        }
        else if (grade == "D") {
            return 5;
        }
        else if (grade == "F") {
            return 6;
        }
        else if (grade == "G") {
            return 7;
        }
        else {
            return 0;
        }
    }

    public static String[] getGrades() {
        // getting the grades and storing them in a list
        String[] gradesList = {"", "", "", "", "", ""};
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Test 1: What is your 1st theory grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
        gradesList[0] = convertOptionToGrade(scanner.nextInt());

        scanner = new Scanner(System.in);
        System.out.print("Test 1: What is your 1st dry run grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
        gradesList[1] = convertOptionToGrade(scanner.nextInt());
        
        scanner = new Scanner(System.in);
        System.out.print("Test 1: What is your 1st program grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
        gradesList[2] = convertOptionToGrade(scanner.nextInt());

        scanner = new Scanner(System.in);
        System.out.print("Test 2: What is your 2nd theory grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
        gradesList[3] = convertOptionToGrade(scanner.nextInt());

        scanner = new Scanner(System.in);
        System.out.print("Test 2: What is your 2nd dry run grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
        gradesList[4] = convertOptionToGrade(scanner.nextInt());
        
        scanner = new Scanner(System.in);
        System.out.print("Test 2: What is your 2nd program grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
        gradesList[5] = convertOptionToGrade(scanner.nextInt());

        return gradesList;
    }

}
