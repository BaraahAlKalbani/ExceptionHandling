import java.io.*;

public class ToUpperCase {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            File file = new File("dataFile/result.txt");
            // Open the input and output files
            if (file.createNewFile()) {
                System.out.println("File created successfully");
            }
            // Open the input and output files

            BufferedReader reader = new BufferedReader(new FileReader("dataFile/input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("dataFile/result.txt"));

            // Read each line from the input file and convert it to upper case
            String line;
            while ((line = reader.readLine()) != null) {
                String uppercaseLine = line.toUpperCase();
                writer.write(uppercaseLine);
                writer.newLine();
            }

            // Close the input and output files
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
