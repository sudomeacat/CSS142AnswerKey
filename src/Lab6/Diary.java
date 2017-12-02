package Lab6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


@SuppressWarnings("ALL")
public class Diary {
    public static void main(String[] args) {
        // Needed variables
        int mm = 0;
        int dd = 0;
        int yyyy = 0;
        String prose = "";   //Empty string to read prose
      
        //FileOutputStream fos = null;
        PrintWriter output = null;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the date as three integers separated by spaces (i.e mm dd yyyy) ");

        mm = keyboard.nextInt();
        dd = keyboard.nextInt();
        yyyy = keyboard.nextInt();

        System.out.println("Enter as many lines of prose you wish (for your to-do’s list or diary entry)");
        System.out.println("Press CTRL + Z to end your entry");
        try {
            //fos = new FileOutputStream("diaryLog.txt", true);
            output = new PrintWriter(new FileOutputStream("diaryLog.txt", true));
            output.write("...old stuff.");
            output.write(mm + "/" + dd + "/" + yyyy);

            System.out.println("Date added");

            while (keyboard.hasNextLine()) {
                prose = keyboard.nextLine();
                System.out.println(prose);
                output.write(prose + "\n");
            }

            output.close();
        } catch (IOException e) {
            System.out.println("File not found.");
            Runtime.getRuntime().exit(1);
        }

        System.out.println("End of program.");
    }
}


