package Lab4;

import java.math.BigInteger;
import java.util.Scanner;

public class Lab04 {

    /**
     * main method (driver) to execute all the method calls properly
     */
    public static void main(String[] args) {
        int n;

        for (int i = 1; i <= 2; i++) {
            n = i + 3;
            for (int j = n; j <= 10; j += n) {
                System.out.println(j);
            }
            System.out.println(n);
        }

        System.out.println("Part 3");
        countGrains();

        System.out.println("Part 4a");
        powerOfTwo(77);

        System.out.println("Part 4b");
        numBackward(1234554321);

        System.out.println("Part 5");
        straightLine();

        System.out.println("Part 6");
        boxMaker();

        System.out.println("Part 7a");
        shape7a(6);

        System.out.println("Part 7a");
        shape7b(6);
    }


    /**
     * Calculates the number of grains and prints out the result per lab instructions
     *
     * Output: total goes beyond long's numerical capacity.
     */
    public static void countGrains() {
        double total = 0;
        final int days = 64;

        for (int i = 1; i <= days; i++) {
            total += Math.pow(2, i - 1);
            System.out.println("Day " + i + " and you got " + (int) Math.pow(2, i - 1) + " grains of rice for a total of " + String.format("%.0f", total) + " grains of rice.");
        }
    }

    /**
     * Determines if a number is power of 2 and displays result per lab instructions
     */
    public static void powerOfTwo(int numberInput) {
        int count;
        int number = numberInput;

        if (number == 0) {
            System.out.println(numberInput + " is not a power of 2");
            return;
        }
        for (count = 0; number != 1; count++, number >>= 1) {
            if (number % 2 != 0) {
                System.out.println(numberInput + " is not a power of 2");
                return;
            }
        }
        System.out.println(numberInput + " is 2 to the " + count);
    }

    /**
     * Reverses the digits of a given integer, i.e. 12345 would become 54321 per lab instructions
     */
    public static void numBackward(int number) {
        int reversed_number;

        StringBuilder builder = new StringBuilder(Integer.toString(number));
        builder.reverse();
        reversed_number = Integer.parseInt(builder.toString());

        System.out.println("backwards: " + reversed_number + ", " + (number == reversed_number ? "palindrome!" : "not palindrome!"));
    }

    /**
     * Produces and displays a straight line using asterisks per lab instructions
     */
    public static void straightLine() {
        final int size = 3;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    /**
     * void method that asks the user for an integer x (using Scanner), and prints box using asterisks
     * refer to detailed instructions in lab description part 6
     */
    public static void boxMaker() {
        Scanner scanner = new Scanner(System.in);
        int size;

        try {
            System.out.printf("Enter the box size: ");
            size = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Invalid input. Not running");
            return;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf(i == 0 || i == size - 1 ? "*" : j == 0 || j == size - 1 ? "*" : " ");
            }
            System.out.println();
        }
    }

    /**
     * void method to print a shape that is a triangular pattern with sides of 6 asterisks
     * refer to detailed instructions in lab description part 7a
     */
    public static void shape7a(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(". ");
            }
            for (int j = 0; j < number - i; j++) {
                System.out.printf("* ");
            }
            System.out.println();
        }
    }

    /**
     * void method to print a shape that is an "X" pattern with arms of number asterisks each.
     */
    public static void shape7b(int number) {
        for (int i = 0; i < number * 2 + 1; i++) {
            for (int j = 0; j < number * 2 + 1; j++) {
                System.out.printf((i == j || i == number * 2 - j) ? String.format("%2s", "*") : String.format("%2s", "."));
            }
            System.out.println();
        }
    }
}



    
  

