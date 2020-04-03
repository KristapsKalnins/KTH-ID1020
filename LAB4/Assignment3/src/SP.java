/***************************************
 *  05.10.2019 Kristaps Kalniņš TCOMK 2
 *  Djikstra's algorithm used to save
 *  the shortest path from a source to
 *  all other vertecies
 * ************************************/
public class SP
{
    private Edge[] edgeTo;
    private Integer[] vert;
    private double[] distTo;
    private MinPQ<Integer, Double> pq;
    private int source;
    public SP(EdgeWeightedGraph G, int s)
    {
        source = s;
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        vert = new Integer[G.V()];
        pq = new MinPQ<>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        pq.enqueue(s, 0.0);
        while (!pq.isEmpty())
            relax(G, pq.dequeue());
    }
    private void relax(EdgeWeightedGraph G, int v)
    {
        for(Edge e : G.adj(v))
        {
            int w = e.other(v);
            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                vert[w] = v;
                if (pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insertSorted(w, distTo[w]);
            }
        }
    }
    public double distTo(int v){
        return distTo[v];
    } // standard client query methods
    public boolean hasPathTo(int v)
    { return distTo[v] < Double.POSITIVE_INFINITY; }


    public Iterable<Edge> pathTo(int v){
        return pathTo(source, v);
    }

    private Iterable<Edge> pathTo(int s, int v)
    {
        if (!hasPathTo(v)) return null;
        Stack<Edge> path = new Stack<>();
        Edge e ;
        for (int x = v; x != s; x = vert[x]) {
            e = edgeTo[x];
            path.push(e);
        }
        return path;
    }
}