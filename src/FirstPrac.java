import java.io.*;
import java.util.Scanner;
import java.util.SplittableRandom;

public class FirstPrac {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File dataFile = new File("dataFile/data1.txt");

        try {
            if (!dataFile.exists()) {

                PrintWriter newFile = new PrintWriter(dataFile);
                newFile.println("Hello, world!");
                newFile.close();
            }
            Scanner fileScanner = new Scanner(dataFile);
            System.out.println("EnterData: ");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("Have you created the file?  " + e);
        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
    }

}
