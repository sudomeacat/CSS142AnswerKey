package Homework7;

import java.util.Scanner;

/**
 * This class hold 3 sorted floats (times of the race completions in seconds), read by the user at initialization.
 */
@SuppressWarnings("ALL")
public class Race {
    private float time1;
    private float time2;
    private float time3;

    /**
     * This default constructor initializes the object and it's fields.
     */
    public Race() {
        read_input();
        sort_input();
    }

    /**
     * This reads 3 floats or integers from the user and stores them into the member fields
     */
    private void read_input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 3 times as space separated floating points or scalar integers:");
        System.out.printf(">>> ");
        this.time1 = scanner.nextFloat();
        this.time2 = scanner.nextFloat();
        this.time3 = scanner.nextFloat();
    }

    /**
     * This sorts the the fields in ascending order. This sorts by native floating point comparators.
     */
    private void sort_input() {
        if (time1 > time2) {
            float tmp = time1;
            time1 = time2;
            time2 = tmp;
        }
        if (time1 > time3) {
            float tmp = time1;
            time1 = time3;
            time3 = tmp;
        }
        if (time2 > time3) {
            float tmp = time2;
            time2 = time3;
            time3 = tmp;
        }
    }

    public float getTime1() {
        return time1;
    }

    public float getTime2() {
        return time2;
    }

    public float getTime3() {
        return time3;
    }

    /**
     * Returns a string based on how many values are equal to each other.
     *
     * @return A hardcoded java.lang.String based on how many values are equal to each other.
     */
    @Override
    public String toString() {
        if (time1 == time2 && time2 == time3) {
            return "All are tied for first place";
        }
        if (time1 == time2) {
            return "Two are tied for first place";
        }
        else if (time2 == time3){
            return "Two are tied for second place";
        }
        return "";
    }
}
