/*****************************************
 *    05.10.2019 Kristaps Kalniņš TCOMK2
 *    Unit test for assignment 4 that
 *    find the MST of a given graph
 *    using the eager Prim's algorithm
 ****************************************/
import java.util.Scanner;

public class Assignment4 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        StringBuilder build = new StringBuilder();
        while(in.hasNextLine()) {
            build.append(in.nextLine());
            build.append('\n');
        }
        String out = build.toString();
        EdgeWeightedSymbolGraph G;
        G = new EdgeWeightedSymbolGraph(out, " ");
        PrimMST mst = new PrimMST(G.G());
        for (Edge e : mst.edges())
            System.out.println(G.name(e.either()) + " " + G.name(e.other(e.either())) +" "+ e.weight());;
        System.out.println(mst.weight());
    }
}
