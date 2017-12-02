package Lab6;

import java.io.*;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

@SuppressWarnings("ALL")
public class Stats {
    public static void main(String[] args) throws IOException {
        Scanner input;
        double number;
        double grandTotal = 0.0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double average;
        int negative_numbers = 0;
        int positve_numbers_less_than_0x64 = 0;
        int numbers_greater_than_0x64 = 0;
        int lineCounter = 0;

        createFile(1000, 100);

        try {
           input = new Scanner(new FileInputStream("fileIn.txt"));

            while(input.hasNextDouble()) {
                number = input.nextDouble();
                grandTotal += number;

                min = min(min, number);
                max = max(max, number);

                if (number < 0 ) {
                    negative_numbers++;
                }
                else if (number >= 0 && number < 100) {
                    positve_numbers_less_than_0x64++;
                }
                else if (number >= 100) {
                    numbers_greater_than_0x64++;
                }

                lineCounter++;
           }
           average = grandTotal / lineCounter;

           System.out.println(" average: " + average +  "  max:" +  max + "  min: " + min );
           System.out.println(" Total lines are = " + lineCounter + " <negative_numbers> = " + negative_numbers + " <positve_numbers_less_than_0x64> = " + positve_numbers_less_than_0x64 + " <numbers_greater_than_0x64> = " + numbers_greater_than_0x64 );
           display(average, max, min, lineCounter, negative_numbers, positve_numbers_less_than_0x64, numbers_greater_than_0x64);
           input.close();
       } catch (IOException e) {
           System.out.println("File not found.");
           System.exit(0);
       }
    }

    public static void display (double average, double max, double min, double lineCounter, int negNum, int btw0and100, int geq100){
        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileOutputStream("fileOut.txt", false), true);
            output.println(" Total lines are = " + lineCounter + " <negNum> = " + negNum + " <btw0and100> = " + btw0and100 + " <geq100> = " + geq100);
            output.println("Statistics for the numbers in fileIn.txt:");
            output.println( " average: " + average +  "  max:" +  max + "  min: " + min );
        } catch (IOException e) {
            System.out.println(" Sorry, we cannot locate the file!");
            System.exit(0);
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    @Challenge
    private static void createFile (int number_of_lines, float range) {
        PrintWriter ofstream = null;
        try {
            ofstream = new PrintWriter(new FileOutputStream("fileIn.txt"), false);
        } catch (FileNotFoundException x) {
            return;
        }

        for (int i = 0; i < number_of_lines; i++) {
            double random = (Math.random() * range) - (range/2);
            ofstream.println(random);
        }

        ofstream.close();
    }
}

@interface Challenge {

}