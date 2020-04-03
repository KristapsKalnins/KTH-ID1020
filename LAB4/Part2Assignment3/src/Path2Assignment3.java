/**********************************************
 *  05.10.2019 Kristaps Kalniņš TCOMK2
 *  Unit test for printing out topologically
 *  sorted vertices of a graph
 *********************************************/

import java.util.Scanner;

public class Path2Assignment3 {

    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        StringBuilder build = new StringBuilder();
        while (in.hasNextLine()) {
            build.append(in.nextLine());
            build.append('\n');
        }
        String out = build.toString();

        SymbolDigraph sg = new SymbolDigraph(out, " ");
        Topological top = new Topological(sg.G());
        for (int v : top.order())
            System.out.println(sg.name(v));
    }



}
