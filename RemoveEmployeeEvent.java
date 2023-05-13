import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class removeEmployeeEvent {

    public static void removeEmployeeEvent() {
        //get user input
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Employee ID to remove: ");
        String idToRemove = scn.nextLine();
        //scn.nextLine();

        //List<String> lines = new ArrayList<>();
        //access employeedatabase.txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        boolean found = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            //if (line.startsWith("ID:" + idToRemove)) {
            if (line.startsWith(idToRemove)) {
                lines.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + idToRemove + " not found.");
            return;
        }

        try {
            FileWriter writer = new FileWriter("employees.txt");
            for (String line : lines) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
            return;
        }

        System.out.println("Employee with ID " + idToRemove + " was removed.");
    }
}
