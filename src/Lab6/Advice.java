package Lab6;

import java.io.*;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Advice {
    public static void main(String[] args) {
        try {
            PrintWriter advice_output = new PrintWriter(new FileOutputStream("adviceLog.txt", true));

            Scanner fin = new Scanner(new FileInputStream("advice.txt"));
            Scanner cin = new Scanner(System.in);
            String buffer;

            while (fin.hasNextLine()) {
                buffer = fin.nextLine();
                System.out.println(buffer);
            }

            PrintWriter advice_log_output = new PrintWriter(new FileOutputStream("advice.txt", false));

            System.out.println();
            System.out.printf("Continue the chain, enter some advice: ");

            for (;;) {
                String new_advice = cin.nextLine();

                if (new_advice.equals("")) {
                    break;
                }

                advice_output.println(new_advice);
                advice_log_output.println(new_advice);
            }

            fin.close();
            advice_log_output.close();
            advice_output.close();
        } catch (IOException e) {
            System.err.println("File cannot be created");
            Runtime.getRuntime().exit(1);
        }
    }
}
