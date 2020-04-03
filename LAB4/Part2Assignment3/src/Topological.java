/**********************************************
*   05.10.2019 Kristaps Kalniņš TCOMK2
*   Class that uses the directed cycle finder
*   and the depth first order class to make
*   a topological sort or a given digraph.
* *******************************************/
public class Topological
{
    private Iterable<Integer> order; // topological order
    public Topological(Digraph G)
    {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle())
        {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }
    public Iterable<Integer> order()
    { return order; }
    public boolean isDAG()
    { return order == null; }

}