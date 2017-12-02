package Homework6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Homework6 {
    public static void main(String[] args) {
        double air_density = 1.14D;
        double acceleration_by_gravity = 9.81D;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the mass of the skydiver (kg): ");
        double mass = scanner.nextDouble();
        System.out.printf("Enter the cross-sectional area of the skydiver (m/s^2): ");
        double area = scanner.nextDouble();
        System.out.printf("Enter the drag coefficient of the skydiver: ");
        double drag_coefficeint = scanner.nextDouble();
        System.out.printf("Enter the ending time (sec): ");
        double ending_time = scanner.nextDouble();
        System.out.printf("Enter the time step (sec): ");
        double time_step = scanner.nextDouble();
        System.out.printf("Enter the output filename: ");
        String ostream_file_name = scanner.next();
        double[] times = new double[(int)(ending_time * (1.0D / time_step))];
        double[] velocities = new double[(int)(ending_time * (1.0D / time_step))];
        times[0] = 0.0D;
        velocities[0] = 0.0D;

        int i;
        for(i = 1; i < velocities.length; ++i) {
            times[i] = times[i - 1] + time_step;
            velocities[i] = velocities[i - 1] + (9.81D - drag_coefficeint * 1.14 * area / (2.0 * mass) * Math.pow(velocities[i-1], 2.0)) * time_step;
        }

        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(new FileOutputStream(ostream_file_name));
        } catch (IOException var21) {
            return;
        }

        System.out.println("Writing out file. Here are the first few lines");

        for(i = 0; i < times.length; ++i) {
            printWriter.printf("%.3f %.4f\n", times[i], velocities[i]);
        }

        for(i = 0; i < 10; ++i) {
            System.out.printf("%.3f %.4f\n", times[i], velocities[i]);
        }

        printWriter.close();
    }
}
