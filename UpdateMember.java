import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
/*public class UpdateMember {
    private static BufferedReader reader;
    private static Scanner scanner = new Scanner(System.in);

    public static void update(Member memberToUpdate) {
        Scanner scn = new Scanner(System.in);

        int id = Integer.parseInt(memberToUpdate.getMemberID());
        boolean valid = false;

        try {
            File members = new File("members.txt");
            File temp = new File("tempMem.txt");

            reader = new BufferedReader(new FileReader(members));
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
                    System.out.print("\nWhat would you like to update? (Address, DOB, Email, Name, or Member Type): ");
                    
                    String change = getInputFromUser();

                    while(!isValidOption(change)) {
                        System.out.print("\nInvalid option. Please choose a valid option (address, dob, email, name, or member type):");
                        change = getInputFromUser();
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
        } finally {
            scn.close();
        }
    }

    private static boolean isValidOption(String option) {
        return option.equalsIgnoreCase("ID") ||
                option.equalsIgnoreCase("Address") ||
                option.equalsIgnoreCase("DOB") ||
                option.equalsIgnoreCase("Email") ||
                option.equalsIgnoreCase("Member Type") ||
                option.equalsIgnoreCase("Name");
    }

    private static String getInputFromUser() {
        String input = null;

        Console console = System.console();
        if (console != null) {
            input = console.readLine();
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error reading input: " + e.getMessage());
            }
        }

        return input != null ? input : "";
    }
}*/

public class UpdateMember {
    public static void update(Member memberToUpdate) {
        Scanner scn = new Scanner(System.in);

        //int id = validID(scn);
        int id = Integer.parseInt(memberToUpdate.getMemberID());
        boolean newMember = false;
        boolean valid = false;

        SaveToFile.save(memberToUpdate.toString(), "members.txt");
        File members = null;
        File checkouts = null;
        File temp = null;

        BufferedReader reader = null;
        BufferedWriter writer = null;
        BufferedWriter checkoutWriter = null;

        try {
            members = new File("members.txt");
            temp = new File("tempMem.txt");
            checkouts = new File("CheckedOutItems.txt");

            reader = new BufferedReader(new FileReader(members));
            writer = new BufferedWriter(new FileWriter(temp));
            checkoutWriter = new BufferedWriter(new FileWriter(checkouts, true));

            String curr;
            boolean found = false;
            String memberID = "0";
            String lastline = "";

            while ((curr = reader.readLine()) != null) {
                String[] memberInfo = curr.split("\t");
                int memID = Integer.parseInt(memberInfo[0].strip());
                String email = memberInfo[3];
                String origDob = memberInfo[2];
                String address = memberInfo[1];
                String memberType = memberInfo[6];
                String name = memberInfo[5];
                String ssn = memberInfo[4];
                
                Date dob = new Date(0);
                boolean newDOB = false;
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                boolean newID = false;

                if (memberInfo.length >= 1 && memID == id && found == false) {
                    found = true;
                    // update member

                    if (id != 0 ) {
                        newMember = false;
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
                                dob = inputDOB(scn, memberToUpdate);
                                break;
                            case "address":
                                address = inputAddress(scn, memberToUpdate);
                                break;
                            case "email":
                                email = inputEmail(scn, memberToUpdate);
                                break;
                            case "member type":
                                memberType = inputType(scn, memberToUpdate);
                                break;
                            case "name":
                                name = inputName(scn, memberToUpdate);
                                break;
                        }
                    } else {
                        System.out.println("\nPlease enter all of the information below: ");
                        System.out.print("---------------------------------------------");
                        newMember = true;

                        address = inputAddress(scn, memberToUpdate);
                        email = inputEmail(scn, memberToUpdate);
                        name = inputName(scn, memberToUpdate);
                        newDOB = true;
                        dob = inputDOB(scn, memberToUpdate);
                        memberType = inputType(scn, memberToUpdate);

                        memberID = GetIDs.returnID("members.txt");
                        memberToUpdate.setMemberID(memberID);

                        String checkoutInfo = String.format("%s\t0\t0\t0\t0\t0\n", memberID);
                        checkoutWriter.write(checkoutInfo);
                    }

                    System.out.println("\nSuccessfully updated member " + memberID + "\n");
                    memberID = memberToUpdate.getMemberID();

                    String dobString;

                    if (newDOB == true) {
                        dobString = dateFormat.format(dob);
                    } else {
                        dobString = origDob;
                    }
                    String updatedInfo = String.format("%-10s\t%-20s\t%-30s\t%-12s\t%-30s\t%-10s\t%-10s\n", memberID, name, address, dobString, email, ssn, memberType);
                    // Write the updated line to the temp file
                    writer.write(updatedInfo);

                } else {
                    // Write the original line to the temp file
                    if (memID != Integer.parseInt(memberID)) {
                        writer.write(curr);
                        writer.newLine();
                    }
                }
            
            }
            if (!found) {
                System.out.println("Member ID not found.");
            } else {
                // Replace the original file with the updated temp file
                System.out.println("Member information updated successfully.");
            }
        } catch (IOException e) {
            System.out.println("There was an error trying to update member " + id);
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
                checkoutWriter.close();
                members.delete();
                temp.renameTo(members);
            } catch (IOException e) {
                System.out.println("There was an error trying to close the files.");
                e.printStackTrace();
            }
        }
        scn.close();
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
        return option.equalsIgnoreCase("Address") ||
                option.equalsIgnoreCase("DOB") ||
                option.equalsIgnoreCase("Email") ||
                option.equalsIgnoreCase("Member Type") ||
                option.equalsIgnoreCase("Name");
    }

    private static String inputAddress(Scanner scn, Member memberToUpdate) {
        String address;
        
        System.out.print("\nEnter new address: ");
        address = scn.nextLine();
        memberToUpdate.setAddress(address);

        return address;
    }   

    private static String inputEmail(Scanner scn, Member memberToUpdate) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        String email = "";
        boolean first = true;

        while(!pattern.matcher(email).matches()) {
            if(first == true) {
                System.out.print("\nEnter new email: ");
                first = false;
            } else {
                System.out.print("\nPlease input a valid email address: ");
            }
            email = scn.nextLine();
        }

        memberToUpdate.setEmail(email);
        
        return email;
    }

    private static String inputName(Scanner scn, Member memberToUpdate) {
        String name;

        System.out.print("\nEnter new name: ");
        name = scn.nextLine();
        memberToUpdate.setName(name);
        
        return name;
    }

    private static Date inputDOB(Scanner scn, Member memberToUpdate) {
        Date dob = new Date(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        dateFormat.setLenient(false);
        boolean validDOB = false;

        while(validDOB != true) {
            try {
                System.out.print("\nEnter new Member Date of Birth(mm/dd/yyyy): ");
                String input = scn.nextLine();

                dob = dateFormat.parse(input);
                validDOB = true;
            } catch (ParseException e) {
                System.out.println("\nInvalid date format. Please enter date of birth in mm/dd/yyyy format.");
                continue;
            }
        }
        memberToUpdate.setDateOfBirth(dob);

        return dob;
    }

    private static String inputType(Scanner scn, Member memberToUpdate) {
        String memberType;

        while(true) {
            System.out.print("\nEnter new member type: ");
            memberType = scn.nextLine();

            if (memberType.equalsIgnoreCase("External") == false && memberType.equalsIgnoreCase("Student") == false && memberType.equalsIgnoreCase("Professor") == false) {
                System.out.println("Invalid member type. Please enter either external, student or professor.");
            } else {
                break;
            }
        }

        memberToUpdate.setMemberType(memberType);

        return memberType;
    }
}