import java.io.*;
import java.util.*;

public class BufferWriter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read the name and email from the user
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        String data = "";

        // Read the contents of the file "data.csv"
        try (BufferedReader reader = new BufferedReader(new FileReader("dataFile/data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data = line + "\n";
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate a new ID for the new record
        int id = 1;
       try { if (!data.isEmpty()) {
            String lastLine = data.substring(data.lastIndexOf("\n") + 1);
            id = Integer.parseInt(lastLine.split(",")[0]) + 1;
        }}catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            
        }

        // Append the new record to the end of the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dataFile/data.csv", true))) {
            writer.write(String.format("%03d, %s, %s, true\n", id, name, email));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
