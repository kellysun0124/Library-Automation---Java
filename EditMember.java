import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EditMember {
    static String EditMember {
        Scanner scn = new Scanner(System.in);
        //get input of member ID
        System.out.println("Enter member ID to edit: ");
        int idToEdit = scn.nextInt();
        scn.nextLine();
        //READ memebers.txt
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

        //get input of the new information
        system.out.println("Enter new name: ")
        String newName = scn.nextLine();
        system.out.println("Enter new address: ")
        String newAddress = scn.nextLine();
        while(valid != true) {
            try {
                System.out.print("Enter new Date of Birth(mm/dd/yyyy): ");
                String input = scn.nextLine();

                dob = dateFormat.parse(input);
                valid = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date of birth in mm/dd/yyyy format.");
                continue;
            }
        }
        system.out.println("Enter new email: ")
        String newEmail = scn.nextLine();
        //why would your ssn or date of birth change though -.-?
        system.out.println("Enter new SSN: ")
        String newSSN = scn.nextLine();
        system.out.println("Enter new MemberType: ")
        String newMemberType = scn.nextLine();
        //THIS IS WHERE I STOPPED---------------------------------------------I'm not sure how to edit just a line....
        //THOUGHT!! can we use the set methods in members to edit?????

        //find specific member to edit
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
            System.out.println("Member with ID " + idToEdit + " not found.");
            return;
        }



        //need to edit the specific member with new info and save to file
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




        System.out.println("Member with ID " + idToEdit + " was edited successfully.");


    }
}
