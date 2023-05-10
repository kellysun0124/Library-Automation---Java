import java.io.*;
import java.util.Scanner;

public class removeCollectionEvent {

    public static void removeCollectionEvent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the ID of the collection to be removed: ");
        String collectionId = scanner.nextLine();

        File myFile = new File("Collectiondatabase.txt");
        File tempFile = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile));
                FileWriter writer = new FileWriter(tempFile)) {
            String lineToRemove = collectionId;
            String currentLine;
            boolean found = false;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.startsWith(lineToRemove)) {
                    found = true;
                    continue;
                } else {
                    writer.write(currentLine + "\n"); // changed to "\n"
                }
            }

            if (!found) {
                System.out.println("Collection not found.");
            } else {
                System.out.println("Collection removed successfully.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(tempFile));
            FileWriter writer = new FileWriter(myFile);
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] elements = currentLine.split("\t");
                if (elements.length < 8) {
                    continue;
                }

                String collectionID = elements[0];
                String title = elements[1];
                String publisher = elements[2];
                String genre = elements[3];
                String ISBN = elements[4];
                String type = elements[5];
                int runtime = Integer.parseInt(elements[6]);

                String formattedCollection = String.format("%s\t%s\t%s\t%s\t%s\t%s",
                        collectionID, title, publisher, genre, ISBN, type, runtime);
                writer.write(formattedCollection + "\n"); // changed to "\n"
            }

            writer.close();
            reader.close();

            if (!myFile.delete()) {
                System.out.println("Could not delete the original file.");
            }
            if (!tempFile.renameTo(myFile)) {
                System.out.println("Could not rename the temporary file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}