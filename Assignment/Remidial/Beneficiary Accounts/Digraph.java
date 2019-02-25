import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Class for digraph.
 */
public class Digraph {
    /**
     * Newline declaration.
     */
    /**
     * number of V in this digraph.
     */
    private final int V;
    /**
     * number of edges in this digraph.
     */
    private int edges;
    /**
     * adj[v] = adjacency list for vertex v.
     */
    private Bag<Integer>[] adj;
    /**
     * adj[v] = adjacency list for vertex v.
     */
    private int[] indegree;

    /**
     * Initializes an empty digraph with <em>V</em> V.
     *
     * @param  V1 the number of V
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph(final int V1) {
        if (V1 < 0) {
            throw new IllegalArgumentException(
                "Number of V in a Digraph must be nonnegative");
        }
        this.V = V1;
        this.edges = 0;
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * Initializes a new digraph that is a deep copy of the specified digraph.
     *
     * @param  digraph the digraph to copy
     */
    public Digraph(final Digraph digraph) {
        this(digraph.V());
        this.edges = digraph.edges();
        for (int v = 0; v < V; v++) {
            this.indegree[v] = digraph.indegree(v);
        }
        for (int v = 0; v < digraph.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : digraph.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    /**
     * Returns the number of V in this digraph.
     *
     * @return the number of V in this digraph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
    public int edges() {
        return edges;
    }
    /**
     * Validate Vertex.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    /**
     * Adds the directed edge v→w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * @throws IllegalArgumentException unless both
     * {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        edges++;
    }

    /**
     * Returns the V adjacent from vertex {@code v} in this digraph.
     *
     * @param  v the vertex
     * @return the V adjacent from vertex {@code v}
     * in this digraph, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the number of directed edges incident from vertex {@code v}.
     * This is known as the <em>outdegree</em> of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the outdegree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int outdegree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns the number of directed edges incident to vertex {@code v}.
     * This is known as the <em>indegree</em> of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the indegree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int indegree(final int v) {
        validateVertex(v);
        return indegree[v];
    }

    /**
     * Returns the reverse of the digraph.
     *
     * @return the reverse of the digraph
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

}
