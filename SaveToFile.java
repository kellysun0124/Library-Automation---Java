import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class SaveToFile {
    public static void save(String obj, String filename) {
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(filename));
            
            myWriter.write(obj);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while trying to write the object to a file: " + e.getMessage());
        }
    }
}
