import java.util.Scanner;

class Graph {
	int V;
	int E;
	public Bag<Integer>[] agj;
	Graph(int v) {
		this.V = v;
		this.E = 0;
		agj = (Bag<Integer>[]) new Bag[v];
		for (int i = 0; i < v ; i++ ) {
			agj[i] = new Bag<Integer>();
		}
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public void addEdge(int v, int w) {
		if (v == w) {
			return;
		}
		if (!hasEdge(v, w)) {
			E++;
			agj[v].add(w);
			agj[w].add(v);

		}
	}
	public Iterable<Integer> adj(int v) {
		return agj[v];
	}
	public boolean hasEdge(int v, int w) {
		for (int value : agj[v] ) {
			if (value == w) {
				return true;
			}
		}
		return false;
	}
	public void Listoutput(int v, int e, String[] str) throws Exception {
		if (e <= 1 && v <= 1) {
			System.out.println(V() + " vertices, " + E() + " edges");
			throw new Exception("No edges");
		} else {
			System.out.println(V() + " vertices, " + E() + " edges");
			for (int i = 0; i < str.length ; i++ ) {
				String strg = "";
				strg = str[i] + ": ";
				for (int ii : agj[i]) {
					strg += str[ii] + " ";
				}
				System.out.println(strg);
			}
		}
	}
	public void Matrixoutput(int v, int e)  throws Exception {
		if (e <= 1 && v <= 1) {
			System.out.println(V() + " vertices, " + E() + " edges");
			throw new Exception("No edges");
		} else {
			System.out.println(V() + " vertices, " + E() + " edges");
			int[][] mat = new int[v][e];
			for (int i = 0; i < v ; i++ ) {
				for (int j = 0; j < v ; j++) {
					if (hasEdge(i, j)) {
						mat[i][j] = 1;
					}
				}
			}
			for (int i = 0; i < v ; i++ ) {
				for (int j = 0; j < V ; j++) {
					System.out.print(mat[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int a = Integer.parseInt(scan.nextLine());
		int b = Integer.parseInt(scan.nextLine());
		Graph graph = new Graph(a);
		String[] str = scan.nextLine().split(",");
		while (scan.hasNext()) {
			String strg = scan.nextLine();
			String[] values = strg.split(" ");
			graph.addEdge(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
		}
		switch (input) {
		case "List":
			try {
				graph.Listoutput(a, b, str);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case "Matrix":
			try {
				graph.Matrixoutput(a, b);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			break;
		}

	}
}

