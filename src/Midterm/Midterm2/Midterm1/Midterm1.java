package Midterm.Midterm2.Midterm1;

public class Midterm1 {
    public static final int NUMBERS = 5;

    public static void main(String[] $) {
        starsProblem();
    }

    public static void starsProblem() {
        for (int i = 1; i <= NUMBERS; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = NUMBERS - i; j >= 0; j--) {
                System.out.print("*");
            }

            System.out.printf(" ");

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
