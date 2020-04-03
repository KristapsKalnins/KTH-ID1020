/*****************************************
 *    05.10.2019 Kristaps Kalniņš TCOMK2
 *    Unit test for assignment 3 that
 *    uses Djikstras algorithm to
 *    find the shortest paths from a
 *    given source and drain
 ****************************************/
import java.util.Scanner;

public class Assignment3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder build = new StringBuilder();
        while (in.hasNextLine()) {
            build.append(in.nextLine());
            build.append('\n');
        }
        String out = build.toString();
        EdgeWeightedSymbolGraph G;

        G = new EdgeWeightedSymbolGraph(out, " ");
        String s = args[0];
        String oth = args[1];
        int t = G.index(oth);
        SP sp = new SP(G.G(), G.index(s));
        System.out.print(s + " to " + G.name(t));
        System.out.print(String.format(" (%4.3f): ", sp.distTo(t)));
        if (sp.hasPathTo(t)) {
            int prev = -1;
            for (Edge e : sp.pathTo(t)) {
                if(prev == e.either()) {
                    System.out.print("(" + G.name(e.either()) + "-" + G.name(e.other(e.either())) + ") ");
                    prev = e.other(e.either());
                }
                else if(G.index(s) != e.other(e.either()) && prev == -1) {
                    System.out.print("(" + G.name(e.either()) + "-" + G.name(e.other(e.either())) + ") ");
                    prev = e.other(e.either());
                }
                else {
                    System.out.print("(" + G.name(e.other(e.either())) + "-" + G.name(e.either()) + ") ");
                    prev = e.either();
                }
            }
        }
        System.out.println();
    }
}
