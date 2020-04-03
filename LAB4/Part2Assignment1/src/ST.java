public class ST<Key extends Comparable<Key>, Value>{
    private Node root;
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    private  int size(Node x){                                                  //Gets size from the counter
        if (x == null)  return 0;
        else            return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {                                       //Standard binary search for value
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }



    public int rank(Key key) { return rank(key, root); }

    private int rank(Key key, Node x) {                                        //Return the amount of nodes smaller than given node
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }


    public boolean contains(Key key) { return get(key) != null; }

    public Iterable<Key> keys()  { return keys(min(), max()); }


    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }


    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)                //Infix traverse through tree to enqueue all keys in iterable queue
    {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public Key min(){
        return min(root).key;
    }                                 //Returns leftmost node
    private Node min(Node x){
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }                                 //Returns rightmost node
    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }



    public void put(Key key, Value val){
        root = put(root, key, val);
    }


    private Node put(Node x, Key key, Value val){                              //Inserts node in correct position and updates size counter
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

}