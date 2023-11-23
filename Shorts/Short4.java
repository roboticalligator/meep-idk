import java.util.Scanner;
import java.lang.Math;

public class Short4 {
    public static void main(String[] args){
        getCFUValues();
    }

    public static void getCFUValues(){
        int highest = -1;
        int total = 0;
        for (int i = 1; i <= 5; i++) {
            int CFUValue;
            Scanner scanner = new Scanner(System.in);

            System.out.print("Sample " + i + ": What was the water quality measurement in CFU/100ml? ");
            CFUValue = scanner.nextInt();

            if (highest < CFUValue) {
                highest = CFUValue;
            }

            total = total + CFUValue;
        }

        System.out.println("The worst water quality today was " + highest + " CFU/100ml.");
        System.out.println("The average water quality today was " + findAverage(total, 5) + " CFU/100ml.");
        System.out.print("The water quality is " + getWaterQuality(highest) + " today.");
    }

    public static int findAverage(float total, int numberOfValues) {
        return Math.round(total / numberOfValues);
    }

    public static String getWaterQuality(int CFUValue) {
        if (CFUValue <= 200) {
            return "GOOD";
        }
        else if (CFUValue <= 400) {
            return "SUFFICIENT";
        }
        else {
            return "POOR";
        }
    }
}
