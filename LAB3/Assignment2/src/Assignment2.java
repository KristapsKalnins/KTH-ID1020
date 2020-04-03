import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int N = 0;
        int minlen = Integer.parseInt(args[0]);
        int sampleSize = Integer.parseInt(args[1]);
        //Assignment2_BST<String, Integer> st = new BST<>();
        Assignment2_ArrayST<String, Integer> st = new Assignment2_ArrayST<>(sampleSize + 1);
        Scanner in = new Scanner(System.in, "UTF-8");

        while (in.hasNext() && N <= sampleSize) { // Build symbol table and count frequencies.
            String word = in.next();
            if (word.length() < minlen) continue; // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
            N++;
        }
        // Find a key with the highest frequency count.
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;
        //System.out.println(max + " " + st.get(max));
        float stop = System.nanoTime();
        stop = ((stop - start) / 1000000F);
        System.out.println(stop);
    }
}
