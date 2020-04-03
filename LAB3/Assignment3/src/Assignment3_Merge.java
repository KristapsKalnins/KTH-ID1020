public class Assignment3_Merge
{
    private static Comparable[] aux; // auxiliary array for merges
    private static Comparable[] aux2;
    public static Comparable[][] sort(Comparable[] a, Comparable[] b)
    {
        aux = new Comparable[a.length];
        aux2 = new Comparable[a.length];
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
    { // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, b, lo, mid); // Sort left half.
        sort(a, b, mid+1, hi); // Sort right half.
        merge(a, b, lo, mid, hi); // Merge results (code on page 271).
    }


    public static void merge(Comparable[] a, Comparable[] b,  int lo, int mid, int hi)
    { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) { // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
            aux2[k] = b[k];
        }
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
            if (i > mid) {
                a[k] = aux[j++];
                b[k] = aux2[j - 1];
            }
            else if (j > hi ) {
                a[k] = aux[i++];
                b[k] = aux2[i - 1];
            }
            else if (less(aux[j], aux[i])){
                a[k] = aux[j++];
                b[k] = aux2[j-1];
            }
            else{
                a[k] = aux[i++];
                b[k] = aux2[i - 1];
            }
    }
    public static boolean less(Comparable a, Comparable b){
        if(a.compareTo(b) == 1) return true;
        else return false;
    }

}