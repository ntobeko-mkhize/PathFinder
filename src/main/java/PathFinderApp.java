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
        pathFinderApp.getFile("map.txt");
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

        // create an empty queue
        Queue<Vertex> q = new ArrayDeque<>();

        q.add(new Vertex(i, j, 0));

        // stores length of longest path from source to destination
        int min_dist = Integer.MAX_VALUE;

        // run till queue is not empty
        while (!q.isEmpty()) {
            // pop front vertex from queue and process it
            Vertex vertex = q.poll();

            // (i, j) represents current cell and dist stores its
            // minimum distance from the source
            i = vertex.getX();
            j = vertex.getY();
            int dist = vertex.getDist();

            // if destination is found, update min_dist and stop
            if (i == a && j == b) {
                min_dist = dist;
                break;
            }

            // check for all 4 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 4; k++) {
                // check if it is possible to go to position
                // (i + row[k], j + col[k]) from current position
                if (moveToVertex(i + row[k], j + col[k])) {
                    // mark next cell as visited and enqueue it
                    graphResult[i + row[k]][j + col[k]] = "\"";
                    q.add(new Vertex(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            System.out.print("The shortest path from source to destination "
                    + "has length " + min_dist);
        } else {
            System.out.print("Destination can't be reached from source");
        }
    }

    private static boolean moveToVertex(int row, int col) {
        return (row >= 0) && (row < graphResult.length) && (col >= 0) && (col < graphResult[row].length)//maybe row -1
                && !"W".equals(graph[row][col]) && !"\"".equals(graphResult[row][col]);
    }
}
