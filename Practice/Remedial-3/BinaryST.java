/**
 * Class for BinarySearchTree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class BinaryST<Key extends Comparable<Key>, Value> {
    /**
     * Root.
     */
    private Node root;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * Key.
         */
        private Key key;
        /**
         * Value.
         */
        private Value val;
        /**
         * Left and right nodes.
         */
        private Node left, right;
        /**
         * Size.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      key   The key
         * @param      val   The value
         * @param      size  The size
         */
        public Node(final Key key, final Value val, final int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BinaryST() {
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * Size function.
     *
     * @return     the size.
     */
    public int size() {
        return size(root);
    }
    /**
     * Helper Size function.
     *
     * @param      x     root
     *
     * @return     the size.
     */
    private int size(final Node x) {
        if (x == null) return 0;
        else {
            return x.size;
        }
    }
    /**
     * Get function.
     *
     * @param      key   The key
     *
     * @return     The value of the parameter
     */
    public Value get(final Key key) {
        return get(root, key);
    }
    /**
     * Helper get function.
     *
     * @param      x     root
     * @param      key   The key
     *
     * @return     The value of the parameter.
     */
    private Value get(final Node x, final Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
    /**
     * Put function.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        root = put(root, key, val);
    }
    /**
     * Helper put function.
     *
     * @param      x     root
     * @param      key   The key
     * @param      val   The value
     *
     * @return     Puts the node at the required position.
     */
    private Node put(final Node x, final Key key, final Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) {
            x.left  = put(x.left,  key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    /**
     * Minimum function.
     *
     * @return     key at minimum.
     */
    public Key min() {
        return min(root).key;
    }
    /**
     * Helper minimum function.
     *
     * @param      x     root
     *
     * @return     Minimum node.
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * Max function
     *
     * @return     Maximum key.
     */
    public Key max() {
        return max(root).key;
    }
    /**
     * Helper Max function.
     *
     * @param      x     root
     *
     * @return     Max node
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * Floor function.
     *
     * @param      key   The key
     *
     * @return     key at floor.
     */
    public Key floor(final Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * Helper Floor function.
     *
     * @param      x     root
     * @param      key   The key
     *
     * @return     node at the floor.
     */
    private Node floor(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * Ceil function.
     *
     * @param      key   The key
     *
     * @return     Value at the ceil position
     */
    public Key ceil(Key key) {
        Node x = ceil(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * Helper ceil function
     *
     * @param      x     root
     * @param      key   The key
     *
     * @return     Node at the ceil position
     */
    private Node ceil(final Node x, final Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceil(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceil(x.right, key);
    }
    /**
     * Select function.
     *
     * @param      k     the selection parameter
     *
     * @return     Key
     */
    public Key select(int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * Helper select function.
     *
     * @param      x     root
     * @param      k     the selection parameter
     *
     * @return     the Node at the position.
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    /**
     * Rank Function.
     *
     * @param      key   The key
     *
     * @return     the rank
     */
    public int rank(final Key key) {
        return rank(key, root);
    }
    /**
     * Rank Helper Function.
     *
     * @param      key   The key
     * @param      x     root node
     *
     * @return     the rank
     */
    private int rank(final Key key, final Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }
    /**
     * Delete Function.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        root = delete(root, key);
    }
    /**
     * Delete Helper.
     *
     * @param      x     root
     * @param      key   The key
     *
     * @return     Node before to be deleted
     */
    private Node delete(Node x, final Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * Function to delete the min value.
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * Helper function to delete the min value.
     *
     * @param      x     Root
     *
     * @return     Minimum Node
     */
    private Node deleteMin(final Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * Deletes the max value.
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
     * Helper function to delete the max value.
     *
     * @param      x     Root
     *
     * @return     Node at Max.
     */
    private Node deleteMax(final Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * Function for keys.
     *
     * @return     Iterable object.
     */
    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue();
        return keys(min(), max());
    }
    /**
     * Function for keys.
     *
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     Iterable object.
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue();
        keys(root, queue, lo, hi);
        return queue;
    }
    /**
     * Helper function for keys.
     *
     * @param      x      Root
     * @param      queue  The queue
     * @param      lo     The lower
     * @param      hi     The higher
     */
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
}
