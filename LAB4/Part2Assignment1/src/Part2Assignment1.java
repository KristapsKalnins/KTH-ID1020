/***************************************
*   05.10.2019 Kristaps Kalniņš TCOMK2
*   Unit test for 1. in part 2. Checks,
*   using DFS, if there is a path from
*   source to drain and if there is
*   prints the vertices which need to
*   be traversed, otherwise informs the
*   user that there are no more paths
* *************************************/
import java.util.Scanner;

public class Part2Assignment1 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        StringBuilder build = new StringBuilder();
        while(in.hasNextLine()) {
            build.append(in.nextLine());
            build.append('\n');
        }
        String out = build.toString();

        SymbolDigraph G = new SymbolDigraph(out, " ");
        String source = args[0];
        Paths start = new Paths(G.G(), G.index(source));
        int end = G.index(args[1]);
        if(start.hasPathTo(end)) {
            System.out.println("Path found! ");
            for (int x : start.pathTo(end))
                if (G.name(x).equals(source)) System.out.println(G.name(x));
                else System.out.println("-" + G.name(x));
        }
        else{
            System.out.println("Path not found! ");
        }
        System.out.println();
    }

}
