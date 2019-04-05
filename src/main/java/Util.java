import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ntobekomkhize@yahoo.com || mkhizenj@gmail.com
 * <p>
 */
public class Util {

    public static void writeResultFile(String graphResult[][]) {
        try {
            System.out.println("Writing to output.txt");
            FileWriter fw = new FileWriter("output.txt");

            for (int i = 0; i < graphResult.length; i++) {

                for (int y = 0; y < graphResult[i].length; y++) {
                    fw.write(graphResult[i][y] + " ");
                }
                fw.write("\n");
            }

            System.out.println("Writing successful");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
