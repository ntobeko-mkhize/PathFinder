import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ntobekomkhize@yahoo.com || mkhizenj@gmail.com
 * <p>
 */
public class Util {

    public static void writeResultFiles(String graph[][], String graphResult[][], String FOLDER) {
        try {
            System.out.println("Writing to input.txt");
            FileWriter fw = new FileWriter(FOLDER + "\\input.txt");

            for (int i = 0; i < graph.length; i++) {

                for (int y = 0; y < graph[i].length; y++) {
                    fw.write(graph[i][y] + " ");
                }
                fw.write("\n");
            }

            System.out.println("Writing input successful");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Writing to output.txt");
            FileWriter fw = new FileWriter(FOLDER + "\\output.txt");

            for (int i = 0; i < graphResult.length; i++) {

                for (int y = 0; y < graphResult[i].length; y++) {
                    fw.write(graphResult[i][y] + " ");
                }
                fw.write("\n");
            }

            System.out.println("Writing output successful");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
