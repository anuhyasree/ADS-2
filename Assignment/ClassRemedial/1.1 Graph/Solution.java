import java.util.*;

interface Graph {
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    int vertices();
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    int edges();
    /**.
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    void addEdge(int v, int w);
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    Iterable<Integer> adj(int v);
    /**.
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    boolean hasEdge(int v, int w);
}
public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String type = input.nextLine();
		int v = Integer.parseInt(input.nextLine());
		int e = Integer.parseInt(input.nextLine());
		String[] str =  input.nextLine().split(",");
		if (type.equals("List")) {
			GraphList g = new GraphList(v);
			for (int i = 0; i < e; i++ ) {
				String[] lis = input.nextLine().split(" ");
				int a = Integer.parseInt(lis[0]);
				int b = Integer. parseInt(lis[1]);
				if (a != b && !g.hasEdge(a, b)) {
					g.addEdge(a, b);
				}

			}
			System.out.println(g.display(str));
		} else {
			AdjMatrixGraph mst = new AdjMatrixGraph(v);
			for (int i = 0; i < e ; i++ ) {
				String[] matrix = input.nextLine().split(" ");

				int a = Integer.parseInt(matrix[0]);
				int b = Integer.parseInt(matrix[1]);
				if (a != b && !mst.hasEdge(a, b)) {
					mst.addEdge(a, b);

				}
			}
			System.out.println(mst.display());
		}


	}
}
