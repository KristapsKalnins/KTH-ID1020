/*******************************************
*   05.10.2019 Kristaps Kalniņš TCOMK2
 *  Eager Prim's algorithm for finding
 *  the minimum spanning tree of a graph
* ******************************************/
public class PrimMST
{
    private Edge[] edgeTo; // shortest edge from tree vertex
    private double[] distTo; // distTo[w] = edgeTo[w].weight()
    private boolean[] marked; // true if v on tree
    private MinPQ<Integer,Double> pq; // eligible crossing edges
    public PrimMST(EdgeWeightedGraph G)
    {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        pq = new MinPQ<>();
        distTo[0] = 0.0;
        pq.enqueue(0, 0.0); // Initialize pq with 0, weight 0.
        while (!pq.isEmpty())
            visit(G, pq.dequeue()); // Add closest vertex to tree.
    }
    private void visit(EdgeWeightedGraph G, int v)
    { // Add v to tree; update data structures.
        marked[v] = true;
        for (Edge e : G.adj(v))
        {
            int w = e.other(v);
            if (marked[w]) continue; // v-w is ineligible.
            if (e.weight() < distTo[w])
            { // Edge e is new best connection from tree to w.
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insertSorted(w, distTo[w]);
            }
        }
    }
    public Iterable<Edge> edges() {
        Bag<Edge> mst = new Bag<Edge>();
        for (int v = 1; v < edgeTo.length; v++)
            mst.add(edgeTo[v]);
        return mst;
    }
    public double weight(){
        double weight = 0;
        for(Edge e : edges()){
            weight += e.weight();
        }
        return weight;
    }
}