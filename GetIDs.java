import java.util.*;
import java.io.*;

public class GetIDs {
    public static String returnID(String filename) {
        File f = new File(filename);
        int count = 0;
        String countString;

        switch (filename) {
            case "members.txt":
                if(f.exists()) {
                    count = countLines(filename);
                } else {
                    count += 1;
                }
                countString = Integer.toString(count);
                return countString;
            case "employees.txt":
                if(f.exists()) {
                    count = countLines(filename);
                } else {
                    count += 1;
                }
                countString = Integer.toString(count);
                return countString;
            case default:
                return "Invalid filename";
        }
    }

    public static int countLines(String filename) {
        int count = 0;
        File f = new File(filename);

        try {
            Scanner sc = new Scanner(f);

            while(sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
            
            sc.close();
            return count+1;
        } catch (Exception e){
            e.getStackTrace();
            return -1;
        }
    }
}
