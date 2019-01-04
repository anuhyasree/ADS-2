import java.util.*;

public class Graph {

    int V;
    int E;
    boolean[][] adj;

    public Graph(final int V) {
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }

    public int V() {
        return V;
    }

    public int E() {
     return E;
 }
    public void addEdge(int v, int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }

    public boolean contains(int v, int w) {
        return adj[v][w];
    }
    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }

    private class AdjIterator implements Iterator<Integer>,
     Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        public void remove()
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}

