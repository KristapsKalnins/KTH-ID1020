

public class Assignment5_SeparateChainingHashST<Key, Value>
{








    private int N; // number of key-value pairs
    private int M; // hash table size
    private Assignment5_SequentialSearchST<Key, Value>[] st; // array of ST objects
    public Assignment5_SeparateChainingHashST()
    { this(997); }
    public Assignment5_SeparateChainingHashST(int M)
    { // Create M linked lists.
        this.M = M;
        st = (Assignment5_SequentialSearchST<Key, Value>[]) new Assignment5_SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new Assignment5_SequentialSearchST();
    }
    private int hash(Key key)
    { return (key.hashCode() & 0x7fffffff) % M; }

    public Value get(Key key)
    { return (Value) st[hash(key)].get(key); }

    public void put(Key key, Value val)
    { st[hash(key)].put(key, val); }

    public boolean contains(Key key) { return get(key) != null; }

    private Iterable<Key> keys(){
        Assignment5_Queue<Key> queue = new Assignment5_Queue<>();
        keys(queue);
        return queue;
    }
    private void keys(Assignment5_Queue<Key> queue){
        for(int i = 0; i < st.length; i++){
            for(Key key : st[i].keys()){
                queue.enqueue(key);
            }
        }
    }
    private Iterable<Assignment5_SequentialSearchST> entries(){
        Assignment5_Queue<Assignment5_SequentialSearchST> queue = new Assignment5_Queue<>();
        entries(queue);
        return queue;
    }
    private void entries(Assignment5_Queue<Assignment5_SequentialSearchST> queue){
        for(int i = 0; i < st.length; i++){
            queue.enqueue(st[i]);
        }
    }

    public void printHashTable(){
        int i = 0;
        for(Assignment5_SequentialSearchST st : this.entries()){
            System.out.println(st.length());
            i++;
        }

    }
}