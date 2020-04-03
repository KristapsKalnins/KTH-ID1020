import java.util.Scanner;
public class Assignment3 {
    public static void main(String[] args){
        //int minlen = Integer.parseInt(args[0]);
       // int wordAmount = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[0]);
        int x = Integer.parseInt(args[1]);

        Assignment3_ArrayST<String, Integer> st = new Assignment3_ArrayST<>(200000);
        Scanner in = new Scanner(System.in, "UTF-8");


        while (in.hasNext()) { // Build symbol table and count frequencies.
            String word = in.next();
           // if (word.length() < minlen) continue; // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }
        // Find a key with the highest frequency count.
//        String max = "";
//        st.put(max, 0);
//        for (String word : st.keys())
//            if (st.get(word) > st.get(max))
//                max = word;
//        System.out.println(max + " " + st.get(max));
        long start = System.currentTimeMillis();
        st.NtoX(n,x);
        long stop = System.currentTimeMillis();
        long amp = (stop - start);
        System.out.println("The N to X frequency took: "+ amp +" ms");

    }

}
