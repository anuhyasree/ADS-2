import  java.util.*;

class percolation{

	public int vertex;

	percolation(int vertex) {
		this.vertex = vertex;
	}

	public boolean connected(boolean[][] grid, Graph graph) {
		int value = 0;
		for (int i = 0; i< vertex; i++ ) {
			for (int j = 0; j< vertex; j++ ) {
				if (grid[i][j]) {
					value = combine(i,j);
				}
				if (i==0) {
					graph.addEdge(value,vertex*vertex);
				}
				if (i==vertex-1) {
					graph.addEdge(value,vertex*vertex);
				}
				if (i-1 >= 0 && grid[i-1][j]) {
					graph.addEdge(value,combine(i-1,j));

				}
				if (i+1 < vertex && grid[i+1][j]) {
					graph.addEdge(value,combine(i+1,j));
				}

			}

		}
		DepthFirstPath depth = new DepthFirstPath(graph, vertex*vertex);
		return depth.hasPathTo(vertex*vertex+1);

	}
	public int combine(int row, int col){
	return((row*vertex)+col);
}
}

public class Solution{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    int vert = input.nextInt();
	    percolation perc = new percolation(vert);
	    boolean[][] grid = new boolean[vert][vert];
	    Graph graph = new Graph(vert*vert+2);
	    try {
	    	while (true){
	    	int row = input.nextInt();
	    	int col = input.nextInt();
	    	grid[row-1][col-1]=true;
	    }
	} catch(Exception e) {

	}finally{
		System.out.println(perc.connected(grid,graph));
	}

	}
}
