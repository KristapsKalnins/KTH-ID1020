/****************************************************
        06.10.2019 Kristaps Kalniņš TCOMK2
        Unit test for assignment 1. Uses
        dfs to find a path from specified
        source to specified end vertex
 *****************************************************/

import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);             //Reads all of the .dat file
        StringBuilder build = new StringBuilder();       //in one big string
        while(in.hasNextLine()) {
            build.append(in.nextLine());
            build.append('\n');
        }
        String out = build.toString();
        //System.out.println(out);
        SymbolGraph G = new SymbolGraph(out, " ");      //Creates symbol graph from string
        String s = args[0];
        String to = args[1];
        Paths search = new Paths(G.G(), G.index(s));
//        for (int v = 0; v < G.G().V(); v++)
//        {
            System.out.println(s + " to " + to + ": ");
            if (search.hasPathTo(G.index(to)))
                for (int x : search.pathTo(G.index(to)))                        //Iterates through the vertices
                    if (G.name(x).equals(s)) System.out.println(G.name(x));     //that leads from source to end
                    else System.out.println("-" + G.name(x));                   //and prints them out
            System.out.println();
//        }
    }
}
