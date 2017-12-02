package Homework5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.out;

@SuppressWarnings("ALL")
public class Homework5Method1 {
    private static double programWeight = 0.0;
    private static double midtermWeight = 0.0;
    private static double finalExamWeight = 0.0;

    public static void main(String[] args) {
        Scanner inputStream;
        String buffer;
        double sum = 0;
        int courseNumber = 0;
        int id = 0;
        int count = 0;

        try {
            inputStream = new Scanner(new FileInputStream("courseData.txt"));
        } catch (FileNotFoundException x) {
            System.err.println("File not found");
            return;
        }

        buffer = inputStream.nextLine();
        // split the buffer with a " " delimiter
        String[] line = buffer.split("[ ]");

        programWeight = Double.parseDouble(line[0]);
        midtermWeight = Double.parseDouble(line[1]);
        finalExamWeight = Double.parseDouble(line[2]);

        while (inputStream.hasNextLine()) {
            buffer = inputStream.nextLine();

            if (buffer.equals("0")) {
                out.println("Class Average: " + sum/count);
                out.println();
                count = 0;
                sum = 0;
                continue;
            }

            line = buffer.split("[ ]");
            if (line.length == 1) {
                courseNumber = Integer.parseInt(line[0]);
                out.println("Grade data for Class " + courseNumber);
                out.println();
                out.printf("%4s%11s%9s%7s%18s%15s\n", "ID", "Programs", "Midterm", "Final", "Weighted Average", "Program grade");
                out.println("  --   --------  -------  -----  ----------------  -------------");
            }
            else {
                id = Integer.parseInt(line[0]);
                //double weightedAverage = testWeightedAverage(Double.parseDouble(line[0]), Double.parseDouble(line[1]), Double.parseDouble(line[2]));
                double weightedAverage = Double.parseDouble(line[1])*programWeight + Double.parseDouble(line[2])*midtermWeight + Double.parseDouble(line[3])*finalExamWeight;
                sum += weightedAverage;
                count++;
                out.printf("%5d%6.0f%10.0f%8.0f%14.2f%16s\n", id, Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3]), weightedAverage, Double.parseDouble(line[1]) >= 70 ? "Pass" : "Fail");
            }
        }
    }

    private static double testWeightedAverage(double program_score, double midterm_score, double final_score) {
        System.out.println("program_score = " + program_score);
        System.out.println("midterm_score = " + midterm_score);
        System.out.println("final_score = " + final_score);

        return program_score*programWeight + midterm_score*midtermWeight + final_score*finalExamWeight;
    }
}
