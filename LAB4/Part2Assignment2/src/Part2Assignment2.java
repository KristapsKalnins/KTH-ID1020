/********************************
 *  05.10.2019 Kristaps Kalniņš
 *  Unit test that find cycles
 *  in a directed graph using
 *  depth first search
* ******************************/
import java.util.Scanner;

public class Part2Assignment2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder build = new StringBuilder();
        while (in.hasNextLine()) {
            build.append(in.nextLine());
            build.append('\n');
        }
        String out = build.toString();

        SymbolDigraph G = new SymbolDigraph(out, " ");
        DirectedCycle cycle = new DirectedCycle(G.G());
        if(cycle.hasCycle())
            for(int x : cycle.cycle())
                System.out.println(G.name(x));


    }
}
