import java.util.HashMap;

public class WordNet {

    public HashMap<Integer, Bag<String>> synset;

    public HashMap<String, Bag<Integer>> synset1;

    public Digraph g;

    public SAP sap;
    // constructor takes the name of the two input files

    public WordNet(String synsets,
                   String hypernyms) throws Exception {
        In syn = new In(synsets);
        In hyp = new In(hypernyms);
        // String[] syns = syn.readAllLines();
        // String[] hyper = hyp.readAllLines();
        this.synset = new HashMap<Integer, Bag<String>>();
        this.synset1 = new HashMap<String, Bag<Integer>>();
        for (String s : syn.readAllLines()) {
            String[] temp = s.split(",");
            int id = Integer.parseInt(temp[0]);
            synset.putIfAbsent(id, new Bag<String>());
            for (String k : temp[1].split(" ")) {
                synset.get(id).add(k);
                synset1.putIfAbsent(k, new Bag<Integer>());
                synset1.get(k).add(id);
            }
        }
        g = new Digraph(synset.size());
        for (String m : hyp.readAllLines()) {
            String[] t = m.split(",");
            for (int i = 1; i < t.length; i++) {
                g.addEdge(Integer.parseInt(t[0]), Integer.parseInt(t[i]));
            }
        }
        int cnt = 0;
        for (int i = 0; i < g.vertices(); i++) {
            if (g.outdegree(i) == 0) {
                cnt++;
            }
        }
        if (cnt != 1) {
            throw new Exception("Multiple roots");
        }
        DirectedCycle dc = new DirectedCycle(g);
        if (dc.hasCycle()) {
            throw new Exception("Cycle detected");
        }
    }

    // returns all WordNet nouns

    public Iterable<String> nouns() {
        return this.synset1.keySet();
    }

    // is the word a WordNet noun?

    public boolean isNoun(String word) {
        return this.synset1.keySet().contains(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (nounA.equals(null) || nounA.equals(null)) {
            return 0;
        } else {
            sap = new SAP(this.g);
            int dist = sap.length(synset1.get(nounA), synset1.get(nounB));
            return dist;
        }

    }

    public Digraph getGraph() {
        return this.g;
    }
    public String sap(String nounA, String nounB) {
        sap = new SAP(this.g);
        int id = sap.ancestor(synset1.get(nounA), synset1.get(nounB));
        String ances = "";
        for (String s : synset.get(id)) {
            ances = s + " " + ances;
        }
        return ances.trim();
    }
}
