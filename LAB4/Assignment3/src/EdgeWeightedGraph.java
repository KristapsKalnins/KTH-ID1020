/*******************************************
 *      05.10.2019 Kristaps Kalniņš TCOMK2
 *      Edge weighted version of the graph
 *      implementation. Uses a bag of type
 *      Edge instead of type Integer.
 ******************************************/

import java.util.Scanner;

public class EdgeWeightedGraph
{
    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Edge>[] adj; // adjacency lists
    public EdgeWeightedGraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Edge>();
    }
    public EdgeWeightedGraph(Scanner in){
        this(in.nextInt());
        int E = in.nextInt();
        for(int i = 0; i < E; i++){
            int v = in.nextInt();
            int w = in.nextInt();
            int weight = in.nextInt();
            addEdge(new Edge(v, w, weight));
        }
    }

    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(Edge e)
    {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public Iterable<Edge> adj(int v)
    { return adj[v]; }
    public Iterable<Edge> edges()
    {
        Bag<Edge> b = new Bag<Edge>();
        for (int v = 0; v < V; v++)
            for (Edge e : adj[v])
                if (e.other(v) > v) b.add(e);
        return b;
    }
}
