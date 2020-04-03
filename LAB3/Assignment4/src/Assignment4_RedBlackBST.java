public class Assignment4_RedBlackBST<Key extends Comparable<Key>, Value>
{

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;


    private class Node{
        Key key; // key
        Value val; // associated data
        Node left, right; // subtrees
        int N; // # nodes in this subtree
        boolean color;

        Node(Key key, Value val, int N, boolean color)
        {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }

    }



    private boolean isRed(Node h){
        if (h == null) return false;
        return h.color == RED;
    }


    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left)
                + size(h.right);
        return x;
    }
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left)
                + size(h.right);
        return x;
    }
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size(){ return size(root);}

    private int size(Node x){
        if (x == null) return 0;
        else return x.N;
    }
    public void put(Key key, Value val)
    {
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value val)
    {
        if (h == null)
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }


    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {                                       //Standard binary search for value of Node
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public boolean contains(Key key) { return get(key) != null; }



    public Iterable<Key> keys()  { return keys(min(), max()); }


    public Iterable<Key> keys(Key lo, Key hi)
    {
        Assignment4_Queue<Key> queue = new Assignment4_Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }


    private void keys(Node x, Assignment4_Queue<Key> queue, Key lo, Key hi)                //Infix traverse through tree to enqueue all keys in iterable queue
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



}