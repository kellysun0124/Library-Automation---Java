import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateMember {
    public static void update(Member memberToUpdate) {
        Scanner scn = new Scanner(System.in);

        int id = validID(scn);
        boolean valid = false;

        try {
            File members = new File("members.txt");
            File temp = new File("tempMem.txt");

            BufferedReader reader = new BufferedReader(new FileReader(members));
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));

            String curr;
            boolean found = false;

            while ((curr = reader.readLine()) != null) {
                String[] memberInfo = curr.split("\t");
                int memID = Integer.parseInt(memberInfo[0]);
                String email = memberInfo[3];
                String origDob = memberInfo[2];
                String address = memberInfo[1];
                String memberType = memberInfo[6];
                String name = memberInfo[5];
                String ssn = memberInfo[4];

                Date dob = new Date(0);
                boolean newDOB = false;
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

                if (memberInfo.length >= 1 && memID == id) {
                    // update member
                    System.out.println("\nCurrent Member Information: " + curr);
                    System.out.println("\nWhat would you like to update? (Address, DOB, Email, Name, or Member Type): ");
                    
                    String change = scn.nextLine();

                    while(!isValidOption(change)) {
                        System.out.println("\nInvalid option. Please choose a valid option (address, dob, email, name, or member type):");
                        change = scn.nextLine();
                    }

                    switch (change.toLowerCase()) {
                        case "dob":
                            newDOB = true;
                            dateFormat.setLenient(false);
                
                            dob = new Date(0);
                            boolean validDOB = false;
                
                            while(validDOB != true) {
                                try {
                                    System.out.print("\nEnter new Member Date of Birth(mm/dd/yyyy): ");
                                    String input = scn.nextLine();
                
                                    dob = dateFormat.parse(input);
                                    validDOB = true;
                                } catch (ParseException e) {
                                    System.out.println("\nInvalid date format. Please enter date of birth in mm/dd/yyyy format.\n");
                                    continue;
                                }
                            }
                            memberToUpdate.setDateOfBirth(dob);
                            break;
                        case "address":
                            System.out.printf("\nEnter new %s: ", change);
                            address = scn.nextLine();
                            memberToUpdate.setAddress(address);
                            break;
                        case "email":
                            System.out.printf("\nEnter new %s: ", change);
                            email = scn.nextLine();
                            memberToUpdate.setEmail(email);
                            break;
                        case "member type":
                            while(true) {
                                System.out.printf("\nEnter new %s: ", change);
                                memberType = scn.nextLine();
                                
                                if (memberType.toLowerCase() != "external" || memberType.toLowerCase() != "student" || memberType.toLowerCase() != "professor") {
                                    System.out.println("Invalid member type. Please enter either external, student or professor.");
                                } else {
                                    break;
                                }
                            }

                            memberToUpdate.setMemberType(memberType);
                            break;
                        case "name":
                            System.out.printf("\nEnter new %s: ", change);
                            name = scn.nextLine();
                            memberToUpdate.setName(name);
                            break;
                    }
                    
                    String idString = String.valueOf(id);
                    String dobString;

                    if (newDOB == true) {
                        dobString = dateFormat.format(dob);
                    } else {
                        dobString = origDob;
                    }
                    String updatedInfo = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s", idString, address, dobString, email, ssn, name, memberType);
                    // Write the updated line to the temp file
                    writer.write(updatedInfo);
                    //writer.newLine();

                    found = true;
                } else {
                    // Write the original line to the temp file
                    writer.write(curr);
                    writer.newLine();
                }
            
            }

            reader.close();
            writer.close();
            
            temp.delete();
            if (!found) {
                System.out.println("Member ID not found.");
            } else {
                // Replace the original file with the updated temp file
                members.delete();
                temp.renameTo(members);
                System.out.println("Member information updated successfully.");
            }
        } catch (IOException e) {
            System.out.println("There was an error trying to update member " + id);
            e.printStackTrace();
        }
    }

    private static int validID(Scanner scn) {
        int id = 0;
        boolean valid = false;

        while(!valid) {
            System.out.print("Enter member ID to edit: ");

            try {
                id = Integer.parseInt(scn.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter an integer.\n");
            }
        }

        return id;
    }

    private static boolean isValidOption(String option) {
        return option.equalsIgnoreCase("ID") ||
                option.equalsIgnoreCase("Address") ||
                option.equalsIgnoreCase("DOB") ||
                option.equalsIgnoreCase("Email") ||
                option.equalsIgnoreCase("Member Type") ||
                option.equalsIgnoreCase("Name");
    }
}
