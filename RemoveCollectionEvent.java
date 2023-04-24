import java.io.*;
import java.util.Scanner;

public class RemoveCollectionEvent {

    public static void removeCollection() {
        Scanner scanner = new Scanner(System.in);

        // Get the ID of the collection to be removed
        System.out.println("Please enter the ID of the collection to be removed: ");
        int collectionId = scanner.nextInt();
        scanner.nextLine();

        // Read the collections.txt file line by line
        File inputFile = new File("Collectiondatabase.txt");
        File tempFile = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(tempFile)) {
            String lineToRemove = "collectionID:" + collectionId;
            String currentLine;
            boolean found = false;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(lineToRemove)) {
                    found = true;
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            if (!found) {
                System.out.println("Collection not found.");
            } else {
                System.out.println("Collection removed successfully.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Overwrite the original file with the updated content
        try {
            BufferedReader reader = new BufferedReader(new FileReader(tempFile));
            FileWriter writer = new FileWriter(inputFile);
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();
            tempFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
