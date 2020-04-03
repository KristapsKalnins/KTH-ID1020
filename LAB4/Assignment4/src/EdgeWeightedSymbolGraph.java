import java.util.Scanner;

public class EdgeWeightedSymbolGraph
{
    private ST<String, Integer> st; // String -> index
    private String[] keys; // index -> String
    private EdgeWeightedGraph G; // the graph



    public EdgeWeightedSymbolGraph(String stream, String sp)
    {
        st = new ST<String, Integer>();
        Scanner in = new Scanner(stream); // First pass
        while (in.hasNextLine()) // builds the index
        {
            String[] a = in.nextLine().split(sp); // by reading strings
            for (int i = 0; i < a.length - 1; i++) // to associate each
                if (!st.contains(a[i])) // distinct string
                    st.put(a[i], st.size()); // with an index.
        }
        keys = new String[st.size()]; // Inverted index
        for (String name : st.keys()) // to get string keys
            keys[st.get(name)] = name; // is an array.
        G = new EdgeWeightedGraph(st.size());
        in = new Scanner(stream); // Second pass
        while (in.hasNextLine()) // builds the graph
        {
            String[] a = in.nextLine().split(sp); // by connecting the
            int v = st.get(a[0]); // first vertex
                G.addEdge(new Edge(v, st.get(a[1]), Double.parseDouble(a[2])));
        }
    }
    public boolean contains(String s) { return st.contains(s); }
    public int index(String s) { return st.get(s); }
    public String name(int v) { return keys[v]; }
    public EdgeWeightedGraph G() { return G; }
}