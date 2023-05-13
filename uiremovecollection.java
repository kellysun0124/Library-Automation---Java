public class uiremovecollection {
    public static RemoveCollectionEvent() {}
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
