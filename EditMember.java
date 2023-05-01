import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EditMember {
    static String EditMember {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Employee ID to edit: ");
        int idToEdit = scn.nextInt();
        scn.nextLine();

        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("members.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }


        system.out.println("Enter new name: ")
        system
        system.out.println("Enter new address: ")

        system.out.println("Enter new Date of Birth (mm/dd/yyyy): ")

        system.out.println("Enter new email: ")

        system.out.println("Enter new SSN: ")

        system.out.println("Enter new MemberType: ")

        String name, String address, Date dateOfBirth, String email, String socialSecurityNumber, String memberID, String memberType

        boolean found = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.startsWith("ID:" + idToEdit)) {
                lines.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + idToEdit + " not found.");
            return;
        }

        try {
            FileWriter writer = new FileWriter("members.txt");
            for (String line : lines) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
            return;
        }




        System.out.println("Employee with ID " + idToEdit + " was edited successfully.");


    }
}
