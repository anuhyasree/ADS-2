import java.util.Scanner;

/**.
 * Interface for graph.
 */
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
	public boolean hasEdge(int v, int w);
}
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * Main function to handle inputs and deliver outputs.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String type = scan.nextLine();
		int vertices = Integer.parseInt(scan.nextLine());
		int edges = Integer.parseInt(scan.nextLine());
		String[] input = scan.nextLine().split(",");
		if (type.equals("List")) {
			GraphList g = new GraphList(vertices);
			for (int i = 0; i < edges; i++) {
				String[] add = scan.nextLine().split(" ");
				int a = Integer.parseInt(add[0]);
				int b = Integer.parseInt(add[1]);
				if (a != b && !g.hasEdge(a, b)) {
					g.addEdge(a, b);
				}
			}
			System.out.println(g.display(input));
		} else {
			AdjMatrixGraph mat = new AdjMatrixGraph(vertices);
			for (int i = 0; i < edges; i++) {
				String[] add = scan.nextLine().split(" ");
				int a = Integer.parseInt(add[0]);
				int b = Integer.parseInt(add[1]);
				if (a != b && !mat.hasEdge(a, b)) {
					mat.addEdge(a, b);
				}
			}
			System.out.println(mat.display());
		}
	}
}
