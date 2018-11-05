/**.
 * Class for kruskal mst.
 */
public class KruskalMST {
    /**.
     * { var_description }
     */
    private static final double FLOATING_POINT_EPSILON = 1E-12;

    /**.
     * { var_description }
     */
    private double weight;
    /**.
     * { var_description }
     */
    private Queue<Edge> mst = new Queue<Edge>();

    /**.
     * Constructs the object.
     *
     * @param      grr   The grr
     */
    public KruskalMST(final EdgeWeightedGraph grr) {
        // more efficient to build heap by passing array of edges
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        // run greedy algorithm
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) { // v-w does not create a cycle
                uf.union(v, w);  // merge v and w components
                mst.enqueue(e);  // add edge e to mst
                weight += e.weight();
            }
        }

        // check optimality conditions
        assert check(G);
    }

    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public double weight() {
        return weight;
    }

    // check optimality conditions (takes time proportional to E V lg* V)

    /**.
     * { function_description }
     *
     * @param      grr   The grr
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check(final EdgeWeightedGraph grr) {

        // check total weight
        double total = 0.0;
        for (Edge e : edges()) {
            total += e.weight();
        }
        if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf(
                "Weight of edges does not equal weight(): %f vs. %f\n",
                total, weight());
            return false;
        }

        // check that it is acyclic
        UF uf = new UF(G.V());
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : G.edges()) {
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning
        //forest (cut optimality conditions)
        for (Edge e : edges()) {

            // all edges in MST except e
            uf = new UF(G.V());
            for (Edge f : mst) {
                int x = f.either(), y = f.other(x);
                if (f != e) {
                    uf.union(x, y);
                }
            }

            // check that e is min weight edge in crossing cut
            for (Edge f : G.edges()) {
                int x = f.either(), y = f.other(x);
                if (!uf.connected(x, y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println(
                            "Edge " + f
                            + " violates cut optimality conditions");
                        return false;
                    }
                }
            }

        }

        return true;
    }
}


