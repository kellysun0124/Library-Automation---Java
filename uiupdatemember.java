import java.io.BufferedWriter;

public class uiupdatemember {
    public static void updateMember() {

        File members = null;
        File checkouts = null;
        File temp = null;

        BufferedReader reader = null;
        BufferedWriter writer = null;
        //BufferedWriter checkoutWriter = null;

        try {
            members = new File("members.txt");
            temp = new File("tempMem.txt");
            //checkouts = new File("CheckedOutItems.txt");

            reader = new BufferedReader(new FileReader(members));
            writer = new BufferedWriter(new FileWriter(temp));
            //checkoutWriter = new BufferedWriter(new FileWriter(checkouts, true));

            String curr;
            boolean found = false;

            while ((curr = reader.readLine()) != null) {
                String[] memberInfo = curr.split("\t");
                String memID = memberInfo[0].strip();

                if(memID.equals(memberID)) {
                    found = true;

                    String updatedInfo = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", memberID, name, address, dob, email, ssn, MemType);
                    membertoupdate.setName(name);
                    membertoupdate.setAddress(address);
                    membertoupdate.setDateOfBirth(dob);
                    membertoupdate.setEmail(email);
                    membertoupdate.setSocialSecurityNumber(ssn);
                    membertoupdate.setMemberType(MemType);

                    writer.write(updatedInfo);
                } else {
                    if(!memID.equals(memberID)) {
                        writer.write(curr);
                        writer.newLine();
                    }
                }
            }

            if(!found) {
                System.out.println("Member not found.");
            } else {
                System.out.println("Member information updated successfully.");
            }
        } catch (IOException e) {
            System.out.println("There was an error trying to update member " + id);
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
                //checkoutWriter.close();
                members.delete();
                temp.renameTo(members);
            } catch (IOException e) {
                System.out.println("There was an error trying to close the files.");
                e.printStackTrace();
            }
        }
    }
}
