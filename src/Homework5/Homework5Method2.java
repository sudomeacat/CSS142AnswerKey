package Homework5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Homework5Method2 {
    private static double w1;
    private static double w2;
    private static double w3;

    public static void main(String[] args) {
        Scanner inputStream;
        int buffer = 0;
        int courseNumber = 0;

        try {
            inputStream = new Scanner(new FileInputStream("courseData.txt"));
        } catch (FileNotFoundException x) {
            System.err.println("File not found");
            return;
        }

        w1 = inputStream.nextDouble();
        w2 = inputStream.nextDouble();
        w3 = inputStream.nextDouble();

        while (inputStream.hasNextLine()) {
            buffer = inputStream.nextInt();
            courseNumber = buffer;
            double total_average = 0;
            int count = 0;

            System.out.println("Grades for course " + courseNumber);
            System.out.println();
            System.out.println("ID | S1 | S2 | S3 | WA | P/F");
            for (; true; count++) {
                int id = inputStream.nextInt();

                if (id == 0) {
                    break;
                }

                int s1 = inputStream.nextInt();
                int s2 = inputStream.nextInt();
                int s3 = inputStream.nextInt();

                double wa = w1*s1 + w2*s2 + w3*s3;
                total_average += wa;
                System.out.println(id + " " + s1 + " " + s2 + " " + s3 +  " " + String.format("%.2f", wa) + " " + (s1 >= 70 ? "pass":"fail"));
            }

            System.out.println("Class average is " + String.format("%.2f", total_average/(double)count));
            System.out.println();
        }
    }

    private static double testWeightedAverage(double program_score, double midterm_score, double final_score) {
        System.out.println("program_score = " + program_score);
        System.out.println("midterm_score = " + midterm_score);
        System.out.println("final_score = " + final_score);

        return program_score*w1 + midterm_score*w2 + final_score*w3;
    }
}
