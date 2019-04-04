import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @developer ntobekomkhize@yahoo.com
 * <p>
 * Alt. Contact mkhizenj@gmail.com
 */
public class PathFinderApp2 {

    static String graph[][] = null;
    static String graphResult[][] = null;

    public static void main(String[] args) {
        System.out.println("The app was started");

        PathFinderApp2 pathFinderApp = new PathFinderApp2();
        pathFinderApp.getFile("map.txt");
        writeResultFile();
    }


    private static void writeResultFile() {
        try {
            FileWriter fw = new FileWriter("output.txt");
            // read character wise from string and write
            // into FileWriter
            for (int i = 0; i < graphResult.length; i++) {

                System.out.println("second line: " + graphResult[i].length);
                for (int y = 0; y < graphResult[i].length; y++) {
                    fw.write(graphResult[i][y] + " ");
                }
                fw.write("\n");
            }

            System.out.println("Writing successful");
            //close the file
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFile(String fileName) {

        //StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        int height = 0;
        int width = 0;

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.trim();
                line = line.replaceAll("\\s+", "");
                width = line.length();

                height++;
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        int currentLine = 0;
        try (Scanner scanner = new Scanner(file)) {

            graph = new String[height][width];
            graphResult = new String[height][width];
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.trim();
                line = line.replaceAll("\\s+", "");

                int charCount = 0;
                for (int i = 0; i < line.length(); i++) {
                    System.out.println("" + line.charAt(i));
                    graph[currentLine][i] = "" + line.charAt(i);
                    graphResult[currentLine][i] = "" + line.charAt(i);
                    charCount++;
                }
                currentLine++;
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //return result.toString();
        return "";

    }
}
