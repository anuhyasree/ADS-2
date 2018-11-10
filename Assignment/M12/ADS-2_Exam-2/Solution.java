import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * epmty constructor.
     */
    private Solution() {
        //empty constructor
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner scan = new Scanner(System.in);
        int cities = Integer.parseInt(scan.nextLine());
        int road = Integer.parseInt(scan.nextLine());
        EdgeWeightedGraph list = new EdgeWeightedGraph(cities);
        for (int i = 0; i < road; i++) {
            String[] tokens = scan.nextLine().split(" ");
            if (!tokens[0].equals(tokens[1])) {
                Edge obj =
                    new Edge(Integer.parseInt(tokens[0]),
                             Integer.parseInt(tokens[1]),
                             Integer.parseInt(tokens[2]));
                list.addEdge(obj);
            }
        }
        String caseToGo = scan.nextLine();
        switch (caseToGo) {
        case "Graph":
            //Print the Graph Object.
            System.out.println(list);
            break;

        case "DirectedPaths":
            // Handle the case of DirectedPaths,
            // where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] tokens = scan.nextLine().split(" ");
            int source = Integer.parseInt(tokens[0]);
            int destination = Integer.parseInt(tokens[1]);
            DijkstraUndirectedSP dijkstraObj;
            dijkstraObj = new DijkstraUndirectedSP(list, source);
            double distBetween = dijkstraObj.distTo(destination);
            if (dijkstraObj.hasPathTo(destination)) {
                System.out.println(distBetween);
            } else {
                System.out.println("No Path Found.");
            }
            break;

        case "ViaPaths":
            // Handle the case of ViaPaths, where
            // three integers are given.
            // First is the source and second is
            //  the via is the one where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] input = scan.nextLine().split(" ");
            int src = Integer.parseInt(input[0]);
            int via = Integer.parseInt(input[1]);
            int dst = Integer.parseInt(input[2]);
            DijkstraUndirectedSP dijkstraObj2 = new DijkstraUndirectedSP(list, src);
            double sum = 0;
            if (dijkstraObj2.hasPathTo(via)) {
                sum += dijkstraObj2.distTo(via);
                String s = src + " ";
                int vert = src;
                for (Edge edg : dijkstraObj2.pathTo(via)) {
                    s += edg.other(vert) + " ";
                    vert = edg.other(vert);
                }
                System.out.println(sum);
                System.out.println(s.trim());
            }


            break;

        default:
            break;
        }
    }
}


