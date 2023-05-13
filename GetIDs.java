import java.util.*;
import java.io.*;

public class GetIDs {
    public static String returnID(String filename) {
        File f = new File(filename);
        int count = 0;
        String countString;

        if(f.exists()) {
            count = countLines(filename);
        } else {
            count += 1;
        }
        countString = Integer.toString(count);
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
            return count;
        } catch (Exception e){
            e.getStackTrace();
            return -1;
        }
    }
}
