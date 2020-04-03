

public class Assignment7_SeparateChainingHashST<Key, Value>
{
    private int N; // number of key-value pairs
    private int M; // hash table size
    private Assignment7_SequentialSearchST<Key, Value>[] st; // array of ST objects
    public Assignment7_SeparateChainingHashST()
    { this(997); }
    public Assignment7_SeparateChainingHashST(int M)
    { // Create M linked lists.
        this.M = M;
        st = (Assignment7_SequentialSearchST<Key, Value>[]) new Assignment7_SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new Assignment7_SequentialSearchST();
    }
    private int hash(Key key)
    { return (key.hashCode() & 0x7fffffff) % M; }

    public Value get(Key key)
    { return (Value) st[hash(key)].get(key); }

    public void put(Key key, Value val)
    { st[hash(key)].put(key, val); }

    public boolean contains(Key key) { return get(key) != null; }

    private Iterable<Key> keys(){
        Assignment7_Queue<Key> queue = new Assignment7_Queue<>();
        keys(queue);
        return queue;
    }
    private void keys(Assignment7_Queue<Key> queue){
        for(int i = 0; i < st.length; i++){
            for(Key key : st[i].keys()){
                queue.enqueue(key);
            }
        }
    }
    private Iterable<Assignment7_SequentialSearchST> entries(){
        Assignment7_Queue<Assignment7_SequentialSearchST> queue = new Assignment7_Queue<>();
        entries(queue);
        return queue;
    }
    private void entries(Assignment7_Queue<Assignment7_SequentialSearchST> queue){
        for(int i = 0; i < st.length; i++){
            queue.enqueue(st[i]);
        }
    }

    public void printHashTable(){
        int i = 0;
        for(Assignment7_SequentialSearchST st : this.entries()){
            System.out.println(st.length());
            i++;
        }

    }
}