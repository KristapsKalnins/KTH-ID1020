import java.util.Scanner;

public class Assignment4 {


    public static void main(String[] args){
        Assignment4_BST<String, Integer> st = new Assignment4_BST<>();
      // RedBlackBST<String, Integer> st = new RedBlackBST<>();
        Scanner in = new Scanner(System.in, "UTF-8");


        while (in.hasNext()) { // Build symbol table and count frequencies.
            String word = in.next();
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }
        // Find a key with the highest frequency count.
        long start = System.nanoTime();
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;
        float amp = (System.nanoTime() - start) / 1000000F;
       // System.out.println(max + " " + st.get(max));
        System.out.println(amp + " ms");
    }
}
