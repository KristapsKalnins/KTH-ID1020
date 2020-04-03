/****************************************************
		06.10.2019 Kristaps Kalniņš TCOMK2
		DFS used to find paths from a
		source to all other vertices in
		the graph
*****************************************************/

public class Paths
{
    private boolean[] marked; // Has dfs() been called for this vertex?
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // source
    public Paths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }
    private void dfs(Graph G, int v)
    {
        marked[v] = true;                           //Mark node "v" as visited
        for (int w : G.adj(v))                      //for each node adjacent to v
            if (!marked[w])                         //if it's not marked
            {
                edgeTo[w] = v;                      //Note down the path to "v"
                dfs(G, w);                          //Repeat dfs with "w"
            }
    }
    public boolean hasPathTo(int v)
    { return marked[v]; }
    public Iterable<Integer> pathTo(int v)
    {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])      //Traverse from end node to start
            path.push(x);                           //node, using the edgeTo array
        path.push(s);
        return path;
    }
}