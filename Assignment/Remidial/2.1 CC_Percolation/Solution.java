import java.util.Scanner;
class Percolation {
    int vertex;
    Percolation(int v) {
        vertex = v;
    }
    public boolean conn(boolean[][] grid, Graph graph) {
    for (int i = 0; i < vertex; i++) {
        for (int j = 0; j < vertex; j++) {
            if (grid[i][j]) {
                int value = combine(i, j);
                if (i == 0) {
                    graph.addEdge(value,
                        vertex * vertex);
                }
                if (i == vertex - 1) {
                    graph.addEdge(value,
                        vertex * vertex + 1);
                }
                if (i - 1 >= 0 && grid[i - 1][j]) {
                    graph.addEdge(value,combine(i - 1, j));
                }
                if (i + 1 < vertex  && grid[i + 1][j]) {
                    graph.addEdge(value,
                        combine(i + 1, j));
                }
                if (j - 1 >= 0 && grid[i][j - 1]) {
                    graph.addEdge(value, combine(i, j - 1));
                }
                if (j + 1 < vertex && grid[i][j + 1]) {
                    graph.addEdge(value, combine(i, j + 1));
                }
            }
        }
    }
    DepthFirstPath input = new DepthFirstPath(
        graph, vertex * vertex);
    return input.hasPathTo(vertex * vertex + 1);
    }
    public int  combine(int row, int col) {
        return ((row * vertex) + col);
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vert = scan.nextInt();
        Percolation perc = new Percolation(vert);
        boolean[][] grid = new boolean[vert][vert];
        Graph graph = new Graph(vert * vert + 2);
        try {
            while (true) {
                int row = scan.nextInt();
                int col = scan.nextInt();
                grid[row - 1][col - 1] = true;
            }
        } catch (Exception e) {
        } finally {
            System.out.println(perc.conn(grid, graph));
        }
    }
}
