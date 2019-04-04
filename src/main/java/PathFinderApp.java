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
    static String graphResult[][] = null;

    static int V = 39;

    public static void main(String[] args) {
        System.out.println("The app was started");

        PathFinderApp pathFinderApp = new PathFinderApp();
        //System.out.println(pathFinderApp.getFile("map.txt"));

//        pathFinderApp.getFile("map.txt");
        findShortestPath();
        //  writeResultFile();
    }

    private static void findShortestPath() {

        int breadth;
//        for (int i = 0; i < graph.length; i++) {
//            breadth = graph[0].length;
//            System.out.println(graph[0][i]);
//        }

        dijkstra(graph, 0);
    }

    private static int minDistance(int dist[], Boolean shortestPathTree[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, index = -1;

        for (int v = 0; v < V; v++)
            if (shortestPathTree[v] == false && dist[v] <= min) {
                min = dist[v];
                index = v;
            }

        return index;
    }

    private static void dijkstra(String graph[][], int src) {
        int distance[] = new int[V]; // The output array. distance[i] will hold
        // the shortest distance from src to i

        // shortestPathTree[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean shortestPathTree[] = new Boolean[V];

        // Initialize all distances as INFINITE and shortestPathTree[] as false
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
            shortestPathTree[i] = false;
        }

        // Distance of source vertex from itself is always 0
        distance[src] = 0;

        // Find shortest path for all vertices
        for (int vCount = 0; vCount < V - 1; vCount++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(distance, shortestPathTree);

            // Mark the picked vertex as processed
            shortestPathTree[u] = true;

            // Update distance value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++) {
//                System.out.println("vertex:: " + v);
//                System.out.println("graphResult[u]:: " + graphResult[u]);
//                graphResult[u][v] = "\"";

                // Update distance[v] only if is not in shortestPathTree, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of distance[v]
//                if (!shortestPathTree[v] && graph[u][v] != "W" &&
//                        distance[u] != Integer.MAX_VALUE ){
//
//                    //distance[v] = distance[u] + graph[u][v];
//                    distance[v] = 0;
//                    graphResult[u][v] = "*";
//
//                    if("E" == graph[u][v])
//                        break;
//                }
            }
        }

        // print the constructed distance array
        //printSolution(distance, V);
    }

//    private static void writeResultFile() {
//        try {
//            FileWriter fw = new FileWriter("output.txt");
//
//            // read character wise from string and write
//            // into FileWriter
//
//            for (int i = 0; i < graphResult.length; i++) {
//                for (int y = 0; y < graphResult[i].length; y++) {
//                    fw.write(graphResult[i][y]);
//                }
//                fw.write("\n");
//            }
//
//
//            System.out.println("Writing successful");
//            //close the file
//            fw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private String getFile(String fileName) {
//
//        //StringBuilder result = new StringBuilder("");
//
//        //Get file from resources folder
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource(fileName).getFile());
//
//        int lineCount = 0;
//
//        try (Scanner scanner = new Scanner(file)) {
//
//            while (scanner.hasNextLine()) {
//                scanner.nextLine();
//                lineCount++;
//            }
//
//            scanner.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        int currentLine = 0;
//        try (Scanner scanner = new Scanner(file)) {
//
//            graph = new String[lineCount][];
//            graphResult = new String[lineCount][];
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                line = line.trim();
//                line.replaceAll("\\s+","");
//                int charCount = 0;
//
//                System.out.println("length: " + line.length());
//                String lineItems[] = new String[line.length()];
//                for (int i = 0; i < line.length(); i++) {
//                    lineItems[charCount] = "" + line.charAt(i);
//                    charCount++;
//                }
//                graph[currentLine] = lineItems;
//                graphResult[currentLine] = lineItems;
//                currentLine++;
//                //result.append(line).append("\n");
//            }
//
//            scanner.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //return result.toString();
//        return "";
//
//    }

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
