public class CC {
    /**.
     * { var_description }
     */
    private boolean[] marked;
    /**.
     * { var_description }
     */
    private int[] id;
    /**.
     * { var_description }
     */
    private int[] size;
    /**.
     * { var_description }
     */
    private int count;

    /**.
     * Constructs the object.
     *
     * @param      Grap  The grap
     */
    public CC(final Graph Grap) {
        marked = new boolean[Grap.vertex()];
        id = new int[Grap.vertex()];
        size = new int[Grap.vertex()];
        for (int v = 0; v < Grap.vertex(); v++) {
            if (!marked[v]) {
                dfs(Grap, v);
                count++;
            }
        }
    }

    // depth-first search for a Graph

    /**.
     * { function_description }
     *
     * @param      Grr   The grr
     * @param      v     { parameter_description }
     */
    private void dfs(final Graph Grr, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : Grr.adj(v)) {
            if (!marked[w]) {
                dfs(Grr, w);
            }
        }
    }

    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int id(final int v) {
        validateVertex(v);
        return id[v];
    }

    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size(final int v) {
        validateVertex(v);
        return size[id[v]];
    }

    /**
     * Returns the number of connected components in the graph {@code G}.
     *
     * @return the number of connected components in the graph {@code G}
     */
    public int count() {
        return count;
    }

    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean connected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean areConnected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}

    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int[] idarr() {
        return id;
    }

}