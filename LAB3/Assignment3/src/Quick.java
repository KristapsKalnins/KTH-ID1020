public class Quick
{
    public static Comparable[][] sort(Comparable[] a, Comparable[] b)
    {
        int Size = 0;
        for(int i = 0; i < a.length; i++)
            if(a[i] != null)
            Size++;

        Comparable[] resize1 = new Comparable[Size];
        Comparable[] resize2 = new Comparable[Size];
        for(int i = 0; i < resize1.length; i++)
            if(a[i] != null)
            resize1[i] = a[i];
        for(int i = 0; i < resize1.length; i++)
            if(b[i] != null)
            resize2[i] = b[i];

        a = resize1;
        b = resize2;

        sort(a, b , 0, a.length - 1);
        Comparable[][] out = new Comparable[2][Size];
        out[0] = a;
        out[1] = b;
        return out;

    }
    private static void sort(Comparable[] a, Comparable[] b, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, b, lo, hi); // Partition (see page 291).
        sort(a,b, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a,b, j+1, hi); // Sort right part a[j+1 .. hi].
    }

    private static int partition(Comparable[] a, Comparable[] b, int lo, int hi)
    { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1; // left and right scan indices
        Comparable v = a[lo]; // partitioning item
        while (true)
        { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, b, i, j);
        }
        exch(a, b, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    public static boolean less(Comparable a, Comparable b){
        if(a.compareTo(b) == 1) return true;
        else return false;
    }

    public static void exch(Comparable[] a, Comparable[] b,int lo, int hi){
        Comparable temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
        temp = b[lo];
        b[lo] = b[hi];
        b[hi] = temp;
    }


//    public static void main(String[] args){
//        Comparable[] test = {8,1,0,2,9,3,8,4,7,5,6};
//        Comparable[] test2 = {'Y', 'S', 'D', 'Q', 'E', 'R', 'T', 'U', 'P', 'Z', 'C'};
//        sort(test, test2);
//        for(int i = 0; i < test.length; i++){
//            System.out.print("[" + test[i] +"], ");;
//        }
//        System.out.println();;
//        for(int i = 0; i < test.length; i++){
//            System.out.print("[" + test2[i] +"], ");;
//        }

}