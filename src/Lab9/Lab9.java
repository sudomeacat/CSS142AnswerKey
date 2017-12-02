package Lab9;

import java.util.Arrays;

@SuppressWarnings("ALL")
public class Lab9  {

    public static void main(String [] args) {
        // Test random matrix of integers
        int[][] a = randomMatrix (7, 20, 100);
        // use the above array to test next rowSum()

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%3d ", a[i][j]);
            }
            System.out.println();
        }

        int rowTotal = rowSum( a, 0);
        System.out.println("\n Sum of row  = " + rowTotal);

        // use the above array to test next colSum()
        int columSum = colSum( a, 0);
        System.out.println("\n Sum of columns  = " + columSum);

        isSquare(a);

        int[][] nonsquare = { {1,2,3}, {4,5}, {6,7,8,9} };
        int[][] notlatin = { {2,1,3}, {2,3,1}, {3,1,2} };
        int[][] latin = { {1,2,3}, {2,3,1}, {3,1,2} };
        int[][] allneg = { {-10,-12,-3}, {-4,-5,-6,-8}, {-7,-8} };
        int[][] notSquare = { {10, 12, 3, 17}, { 4, 5, 16, 18}, { 7, 9, 10, 45} };
        int[][] perfectSquare = {{1, 2, 3, 4}, { 5, 6, 7, 8}, { 9, 10, 11, 12}, { 13, 14, 15, 16}};

        // Your tests, here are 2 to start with
        System.out.println(isLatin(perfectSquare) ? "true" : "false");
        isSquare(perfectSquare);
    }

    public static int [][]randomMatrix (int N, int start, int end) {
        int matrix[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomGenerator(end, start);
            }
        }

        return matrix;
    }

    public static int randomGenerator( int end, int start){
        return (int)(Math.random() * (end - start)) + start;
    }

    public static int rowSum( int[][] a, int i) {
        int sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += a[i][j];
        }
        return sum;
    }

    public static int colSum( int[][] a, int j) {
        int sum = 0;
        for (int i = 0; i < a[j].length; i++) {
            sum += a[i][j];
        }
        return sum;
    }

    public static boolean isSquare(int[][] a) {
        return a.length == a[0].length;
    }

    // (e) boolean isLatin(int[][] a) returns true if the 2-D array a is a Latin square
    // (i.e. an n-by-n matrix such that each row and each column contains the values
    // from 1 through n with no repeats)
    public static boolean isLatin(int[][] a) {
        boolean left_true = true;
        boolean right_true = true;

        int[] row_copy = Arrays.copyOf(a[0], a[0].length);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != row_copy) {
                left_true = false;
                break;
            }
            ShiftNumbers.rotateRight(row_copy);
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != row_copy) {
                right_true = false;
                break;
            }
            ShiftNumbers.rotateLeft(row_copy);
        }

        return left_true || right_true;
    }

    // 2. In a different class named ShiftNumbers.java write a program that takes integer M as the number of both rows and columns for your 2D array.
    // Create the same exact  2D array as displayed in Lab handout.

  }






