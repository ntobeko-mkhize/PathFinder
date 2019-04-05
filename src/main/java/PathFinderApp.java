import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ntobekomkhize@yahoo.com || mkhizenj@gmail.com
 * <p>
 */
public class PathFinderApp {

    private static String graph[][] = null;
    private static String graphResult[][] = null;

    private static Vertex startVertex = null;
    private static Vertex destinationVertex = null;

    private static final int row[] = {-1, 0, 0, 1};
    private static final int col[] = {0, -1, 1, 0};

    public static void main(String[] args) {
        System.out.println("The app was started");

        PathFinderApp pathFinderApp = new PathFinderApp();

        System.out.println("looking for file map.txt at location: " + args[0]);
        pathFinderApp.getFile(args[0] + "\\map.txt");
        pathFinderApp.findLocale();
        pathFinderApp.findShortestPath_BFS();
        Util.writeResultFiles(graph, graphResult);

        System.out.println("The app completed");
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

    private static void findLocale() {

        boolean start = false, destination = false;
        for (int i = 0; i < graph.length; i++) {
            for (int y = 0; y < graph[i].length; y++) {

                if ("S".equals(graph[i][y])) {
                    startVertex = new Vertex(i, y, 0);
                    start = true;
                }

                if ("E".equals(graph[i][y])) {
                    destinationVertex = new Vertex(i, y, 0);
                    destination = true;
                }

                if (start && destination)
                    break;
            }
        }
    }

    private static void findShortestPath_BFS() {
        int i = startVertex.getY();
        int j = startVertex.getX();
        int a = destinationVertex.getY();
        int b = destinationVertex.getX();

        Queue<Vertex> q = new ArrayDeque<>();
        q.add(new Vertex(i, j, 0));

        int min_dist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Vertex vertex = q.poll();

            i = vertex.getY();
            j = vertex.getX();
            int dist = vertex.getDist();

            if (i == a && j == b) {
                min_dist = dist;
                break;
            }

            for (int k = 0; k < 4; k++) {
                if (moveToVertex(i + row[k], j + col[k])) {
                    graphResult[i + row[k]][j + col[k]] = "\"";
                    q.add(new Vertex(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            System.out.print("Found shortest path from start to destination\n");
        } else {
            System.out.print("Could not reach destination"+ "\n");
        }
    }

    private static boolean moveToVertex(int row, int col) {
        return (row >= 0) && (row < graphResult.length) && (col >= 0) && (col < graphResult[row].length)//maybe row -1
                && !"W".equals(graph[row][col]) && !"\"".equals(graphResult[row][col])
                && startVertex.getY() != row &&  startVertex.getX() != col;
    }
}
