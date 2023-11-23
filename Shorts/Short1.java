/* ***************************************
  @author    Anne Yingying Li
  @SID       231046712
  @date      29 September 2023
  @version   1

    A program that prints my initials (PC)
    in big letters made out of small ones.
   ****************************************/

class Short1 {
// defining a class
    
    public static void main (String[] args) {
        printAL();
    }

    
    public static void printAL () {
        // outputing the initials A and then L
        printA();
        printL();
        return;
    }

    public static void printA () {
        // outputing the letter A
        System.out.println("  AA  ");
        System.out.println(" A  A");
        System.out.println("A    A");
        System.out.println("AAAAAA");
        System.out.println("A    A");
        System.out.println("A    A");
        System.out.println();
        return;
    }

    public static void printL() {
        // outputing the letter L
        System.out.println("L");
        System.out.println("L");
        System.out.println("L");
        System.out.println("L");
        System.out.println("L");
        System.out.println("LLLLLL");
        System.out.println();
        return;
    }
} // end class initials

