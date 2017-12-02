package Lab5;

import java.util.Scanner;
import java.util.*;

public class Lab5 {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        System.out.println("Welcome to Lab5.Lab5!");
        show_menu();
        do {
            System.out.println();
            System.out.printf(">>> ");
            input = scanner.nextInt();

            switch (input) {
                case 0:
                    System.out.println("Exiting program.");
                    return;
                case 1:
                    getRichQuick();
                    break;
                case 2:
                    System.out.println("What is your x value.");
                    double number = scanner.nextDouble();
                    System.out.println("e^" + number + " = " + eTaylor(number));
                    break;
                case 3:
                    palindromeCheck();
                    break;
                case 4:
                    show_menu();
                    break;
            }
        } while (input > 0);
    }

    public static void getRichQuick() {
        double money = 1.0;

        for (int i = 0; money < 1_000_000; i++, money += 1 + money/2) {
            System.out.printf("Day %d: $%.2f + (1 + %.2f) = %.2f\n", i, money, money/2, money + (1 + money/2));
        }
    }

    public static double eTaylor( double x ) {
        double taylor_number = 1 + x;

        for (int i = 2; i <= 20; i++) {
            taylor_number += Math.pow(x, i)/factorial(i);
        }

        return taylor_number;
    }

    private static double factorial (double n) {
        double total = 1;
        for (double i = n; i >= 1; i--) {
            total *= i;
        }
        return total;
    }

    public static void palindromeCheck() {
        int count = 0;
        int total = 0;

        System.out.println("Enter some words separated by a space: ");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split("[ ]");

        for (String word : words ) {
            total++;
            if (isPalindrome(word)) {
                count++;
                System.out.println(" " + total + " " + word);
            }
        }

        System.out.printf("There are %d palindromes out of %d words.\n", count, total);
    }

    private static boolean isPalindrome(String word) {
        StringBuilder s = new StringBuilder(word);

        return s.reverse().toString().equals(word);
    }

    private static void show_menu() {
        System.out.println("Enter 1 to check how long it takes to get rich on a magic dollar coin.");
        System.out.println("Enter 2 to calculate e^x for any real x.");
        System.out.println("Enter 3 to enter palindrome words.");
        System.out.println("Enter 4 to re-print the menu. ");
        System.out.println("Enter 0 to exit.");
    }
}
