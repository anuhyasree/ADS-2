public class DirectedCycle {

    public boolean[] marked;

    public int[] edgeTo;

    public boolean[] onStack;

    public Stack<Integer> cycle;

    public DirectedCycle(Digraph g) {
        marked  = new boolean[g.vertices()];
        onStack = new boolean[g.vertices()];
        edgeTo  = new int[g.vertices()];
        for (int v = 0; v < g.vertices(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(g, v);
            }
        }
    }

    public void dfs(Digraph g, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }


    public boolean hasCycle() {
        return cycle != null;
    }


    public Iterable<Integer> cycle() {
        return cycle;
    }
}

