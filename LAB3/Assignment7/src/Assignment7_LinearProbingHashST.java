public class Assignment7_LinearProbingHashST<Key, Value>
{
    private int N; // number of key-value pairs in the table
    private int M = 16; // size of linear-probing table
    private Key[] keys; // the keys
    private Value[] vals; // the values
    public Assignment7_LinearProbingHashST(int cap)
    {
        this.M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }
    private int hash(Key key)
    { return (key.hashCode() & 0x7fffffff) % M; }
    private void resize(int cap)
    {
        Assignment7_LinearProbingHashST<Key, Value> t;
        t = new Assignment7_LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }
    public void put(Key key, Value val)
    {
        if (N >= M/2) resize(2*M); // double M (see text)
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) { vals[i] = val; return; }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    public Value get(Key key)
    {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public boolean contains(Key key) { return get(key) != null; }

}
