public class Assignment7_SequentialSearchST<Key, Value>
{
    private Node first; // first node in the linked list
    private class Node
    { // linked-list node
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next)
        {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public Value get(Key key)
    { // Search for key, return associated value.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val; // search hit
        return null; // search miss
    }
    public void put(Key key, Value val)
    { // Search for key. Update value if found; grow table if new.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
            { x.val = val; return; } // Search hit: update val.
        first = new Node(key, val, first); // Search miss: add new node.
    }


    public int length(){
        Node x = first;
        int N =0;
        while (x != null){
            N++;
            x = x.next;
        }
        return N;
    }



    public Iterable<Key> keys()
    {
        Assignment7_Queue<Key> queue = new Assignment7_Queue<Key>();
        keys(queue);
        return queue;
    }


    private void keys(Assignment7_Queue<Key> queue){
        Node x = first;
        while (x != null){
            queue.enqueue(x.key);
            x = x.next;

        }
    }

}