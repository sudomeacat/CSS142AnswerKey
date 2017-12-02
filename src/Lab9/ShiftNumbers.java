package Lab9;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class ShiftNumbers {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an integer, then press Enter");
        final int N = keyboard.nextInt();
    
        // 1. Create your array dynamically here
        int digits[][] = new int[N][N];
        int row[] = new int[N];

        // 2. Now, fill the 2D array with numbers

        for (int i = 0; i < N; i++) {
            row[i] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            digits[i] = Arrays.copyOf(row, row.length);
            rotateLeft(row);
        }


        // 3. Print your 2D array
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("+-");
            }
            System.out.println("+");
            for (int j = 0; j < N; j++) {
                System.out.printf("|%d", digits[i][j]);
            }
            System.out.println("|");
        }

        // 4. print the lower border
        for(int j = 0; j < digits[0].length; ++j) {
            System.out.printf("+-");
        }
        System.out.println("+");
    }

    public static void rotateRight(int[] array) {
        int last_number = array[array.length - 1];

        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = last_number;
    }

    public static void rotateLeft(int[] array) {
        int first_number = array[0];

        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = first_number;
    }
}
