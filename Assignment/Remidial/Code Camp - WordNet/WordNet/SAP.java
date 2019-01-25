import java.util.HashSet;

public class SAP {

    public Digraph graph;

    public Integer dist;

    public Integer ancestor;
    // constructor takes a digraph (not necessarily a DAG)

    public SAP(Digraph dig) {
        this.graph = dig;
        dist = Integer.MAX_VALUE;
    }

    // length of shortest ancestral path between v
    // and w; -1 if no such path

    public int length(int v, int w) {
        BreadthFirstDirectedPaths bfs1 = new BreadthFirstDirectedPaths(
            this.graph, v);
        BreadthFirstDirectedPaths bfs2 = new BreadthFirstDirectedPaths(
            this.graph, w);
        HashSet<Integer> s1 = new HashSet<Integer>();
        //HashSet<Integer> s2 = new HashSet<Integer>();
        for (int i = 0; i < this.graph.vertices(); i++) {
            if (bfs1.hasPathTo(i)) {
                s1.add(i);
            }
            //if (bfs2.hasPathTo(i)) {
              //  s2.add(i);
            //}
        }
        //s1.retainAll(s2);
        for (Integer i : s1) {
            if (dist >= bfs1.distTo(i) + bfs2.distTo(i)) {
                dist = bfs1.distTo(i) + bfs2.distTo(i);
                ancestor = i;
            }
        }
        if (dist == Integer.MAX_VALUE) {
            return -1;
        }
        return dist;
    }

    // a common ancestor of v and w that participates in a shortest
    //ancestral path; -1 if no such path

    public int ancestor(int v, int w) {
        BreadthFirstDirectedPaths bfs1 = new BreadthFirstDirectedPaths(
            this.graph, v);
        BreadthFirstDirectedPaths bfs2 = new BreadthFirstDirectedPaths(
            this.graph, w);
        HashSet<Integer> s1 = new HashSet<Integer>();
        HashSet<Integer> s2 = new HashSet<Integer>();
        for (int i = 0; i < this.graph.vertices(); i++) {
            if (bfs1.hasPathTo(i)) {
                s1.add(i);
            }
            if (bfs2.hasPathTo(i)) {
                s2.add(i);
            }
        }
        s1.retainAll(s2);
        for (Integer i : s1) {
            if (dist >= bfs1.distTo(i) + bfs2.distTo(i)) {
                dist = bfs1.distTo(i) + bfs2.distTo(i);
                ancestor = i;
            }
        }
        if (dist == Integer.MAX_VALUE) {
            return -1;
        }
        return ancestor;
    }

    // length of shortest ancestral path between any vertex in v and
    // any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v,
                      Iterable<Integer> w) {
        for (int i : v) {
            for (int j : w) {
                int tdist = length(i, j);
                if (tdist != -1 && dist >= tdist) {
                    dist = tdist;
                    ancestor = ancestor(i, j);
                }
            }
        }
        if (dist == Integer.MAX_VALUE) {
            return -1;
        }
        return dist;
    }

    // a common ancestor that participates in shortest
    // ancestral path; -1 if no such path

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        for (int i : v) {
            for (int j : w) {
                int tdist = length(i, j);
                if (tdist != -1 && dist >= tdist) {
                    dist = tdist;
                    ancestor = ancestor(i, j);
                }
            }
        }
        if (dist == Integer.MAX_VALUE) {
            return -1;
        }
        return ancestor;
    }
}
