import java.io.*;

public class GridSaver {

    private static final String FILE_PATH = "resources/savedgrid.txt";

    public static String readFile() {

        StringBuilder result = new StringBuilder();
        BufferedReader reader = null;

        try {

            String line;
            reader = new BufferedReader(new FileReader(FILE_PATH));
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

        } catch (IOException ex) {
            System.err.println("File not found");
        } finally {

            try {
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }


    public static void writeFile(String savedGrid) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write(savedGrid);
            writer.close();

        } catch (IOException ex) {
            System.out.println("Something went wrong " + ex.getMessage());
        }
    }

}


