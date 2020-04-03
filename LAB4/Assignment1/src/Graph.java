/****************************************************
		06.10.2019 Kristaps Kalniņš TCOMK2
		An implementation of a graph data
		structure using an array of bags to
		store for each vertex the vertecies
		that are adjacent to it
*****************************************************/
import java.util.Scanner;

public class Graph
{
    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Integer>[] adj; // adjacency lists
    public Graph(int V)
    {
        this.V = V; this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V]; // Create array of lists.
        for (int v = 0; v < V; v++) // Initialize all lists
            adj[v] = new Bag<Integer>(); // to empty.
    }
    public Graph(Scanner in)
    {
        this(in.nextInt()); // Read V and construct this graph.
        int E = in.nextInt(); // Read E.
        for (int i = 0; i < E; i++)
        { // Add an edge.
            int v = in.nextInt(); // Read a vertex,
            int w = in.nextInt(); // read another vertex,
            addEdge(v, w); // and add edge connecting them.
        }
    }
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v’s list.
        adj[w].add(v); // Add v to w’s list.
        E++;
    }
    public Iterable<Integer> adj(int v)
    { return adj[v]; }
}