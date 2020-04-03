import java.util.Scanner;

public class Assignment5 {


    public static void main(String[] args){
        Assignment5_SeparateChainingHashST<String, Integer> hashtable = new Assignment5_SeparateChainingHashST<>();
        Scanner in = new Scanner(System.in, "UTF-8");


        while (in.hasNext()) { // Build symbol table and count frequencies.
            String word = in.next();
            //if (word.length() < minlen) continue; // Ignore short keys.
            if (!hashtable.contains(word)) hashtable.put(word, 1);
            else hashtable.put(word, hashtable.get(word) + 1);
        }

        hashtable.printHashTable();


    }
}