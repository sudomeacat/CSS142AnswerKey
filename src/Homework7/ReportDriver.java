package Homework7;

public class ReportDriver {
    /**
     * Main method to test the Report and Race class.
     *
     * @param args used for command-line arguments (unused here)
     */
    public static void main(String... args) {
        String should_repeat;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        do {
            Report report = new Report();

            System.out.printf("The range of race times is: %.2f\n", report.get_range());
            System.out.printf("The average race time is: %.2f\n", report.get_average_time());

            System.out.println();

            System.out.println("First place (s): " + report.getRace().getTime1() +
                    "\nSecond place (s): " + report.getRace().getTime2() +
                    "\nThird place (s): " + report.getRace().getTime3());

            System.out.println(report.getRace());

            System.out.printf("Enter another race (y/!y): ");
            should_repeat = scanner.next();

        } while (should_repeat.equalsIgnoreCase("y"));

        scanner.close();
    }
}
