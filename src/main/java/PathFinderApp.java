import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @developer ntobekomkhize@yahoo.com
 * <p>
 * Alt. Contact mkhizenj@gmail.com
 */
public class PathFinderApp {

    static String graph[][] = null;

    static int V = 39;

    public static void main(String[] args) {
        System.out.println("The app was started");

        PathFinderApp pathFinderApp = new PathFinderApp();
        //System.out.println(pathFinderApp.getFile("map.txt"));

        pathFinderApp.getFile("map.txt");
        findShortestPath();
        writeResultFile();
    }

    private static void findShortestPath() {

        int breadth;
//        for (int i = 0; i < graph.length; i++) {
//            breadth = graph[0].length;
//            System.out.println(graph[0][i]);
//        }

        dijkstra(graph, 0);
    }

    private static int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    private static void dijkstra(String graph[][], int src) {
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]){

                    dist[v] = dist[u] + graph[u][v];

                    if("E" == graph[u][v])
                        break;
                }

        }

        // print the constructed distance array
        //printSolution(dist, V);
    }

    private static void writeResultFile() {
        try {
            FileWriter fw = new FileWriter("output.txt");

            // read character wise from string and write
            // into FileWriter

            for (int i = 0; i < graph.length; i++) {
                for (int y = 0; y < graph[i].length; y++) {
                    fw.write(graph[i][y]);
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

        int lineCount = 0;

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        int currentLine = 0;
        try (Scanner scanner = new Scanner(file)) {

            graph = new char[lineCount][];
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.trim();
                int charCount = 0;

                System.out.println("length: " + line.length());
                char lineItems[] = new char[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    lineItems[charCount] = line.charAt(i);
                    charCount++;
                }
                graph[currentLine] = lineItems;
                currentLine++;
                //result.append(line).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //return result.toString();
        return "";

    }

//    private String getFile(String fileName) {
//
//        StringBuilder result = new StringBuilder("");
//
//        //Get file from resources folder
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource(fileName).getFile());
//
//        try (Scanner scanner = new Scanner(file)) {
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                result.append(line).append("\n");
//            }
//
//            scanner.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return result.toString();
//
//    }
}
