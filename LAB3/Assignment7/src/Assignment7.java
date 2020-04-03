import java.util.Scanner;

public class Assignment7 {

    public static void main(String[] args) {
        //Assignment7_SeparateChainingHashST<String, Integer> hashtable = new SeparateChainingHashST<>();
        Assignment7_LinearProbingHashST<String, Integer> hashtable = new Assignment7_LinearProbingHashST<>(997);
        Scanner in = new Scanner(System.in, "UTF-8");

        long start = System.nanoTime();
        while (in.hasNext()) { // Build symbol table and count frequencies.
            String word = in.next();
            if (!hashtable.contains(word)) hashtable.put(word, 1);
            else hashtable.put(word, hashtable.get(word) + 1);
        }
        float stop = (System.nanoTime()  -  start) / 1000000F;
        System.out.println(stop);
    }
}
