import java.io.*;
import java.util.*;

public class SecondPrac {
/**
 * this class will read a .csv file and store the records in hash map .
 * it also can append the file and insert a new record
 * @param args
 */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        // Linked hash map because it can guarantee elements order
        LinkedHashMap<String, String[]> list = new LinkedHashMap<>();
        String fileLocation = "dataFile/data.csv";
        // calling a void method to read/store file content to the Linked Hash map.
        ReadFile(fileLocation, list);

        String lastId = "";

        // Print every key-value of the Linked Hash map
        for (String key : list.keySet()) {
            System.out.println(Arrays.toString(list.get(key)));
            // storing the key as the last Id number Each Time
            lastId = key;
        }

        // adding new record
        System.out.println("\n\n\n\n\n Add New Record? y,n");
        char newRecord = scan.next().charAt(0);
        scan.nextLine();
        // if yes
        if (newRecord == 'y' || newRecord == 'Y') {

            int newId = Integer.parseInt(lastId) + 1;
            System.out.println("Enter your name: ");

            String name = scan.nextLine();

            System.out.println("Enter your email: ");
            String email = scan.nextLine();
            // calling the write method
            writeRecord(fileLocation, name, email, newId);

        } else {

            System.out.println("end of Program!");

        }

    }

    /**
     * this method will take the data stored in an external file and store it into a
     * Linked Hash map
     * 
     * @param fileLocation: the location of the external file/name
     * @param map:          the Linked hash map to store the
     */
    public static void ReadFile(String fileLocation, LinkedHashMap<String, String[]> map) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
            String line;
            // while the line is not empty:
            while ((line = reader.readLine()) != null) {
                // Insert the line content into an array and separate the columns by ,
                String[] box = line.split(",");
                // put the Id as the Key and the whole array as the value
                map.put(box[0], box);
            }   
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file not found" + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/**
 * this method will 
 * @param fileLocation :the location of the file
 * @param name : the inputed name
 * @param email : the Inputed email
 * @param newId : the next Id for the record
 */
    public static void writeRecord(String fileLocation, String name, String email, int newId) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
            //insert the new record in this format(001,small,small,true)
            writer.write(String.format("%03d, %s, %s, true\n", newId, name, email));
            System.out.println("Added");
            writer.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("The file not found" + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
