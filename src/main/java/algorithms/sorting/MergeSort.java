package algorithms.sorting;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by Orestis on 07/12/2014
 */
public final class MergeSort {

    private MergeSort() {
        // prevent instantiation
    }

    private static Object[] temp;

    public static <T extends Comparable<? super T>> void sort(List<T> array){
        Object[] a = array.toArray();
        temp = new Object[a.length];
        sort(a, 0, a.length - 1);
        ListIterator<T> i = array.listIterator();
        for (int j=0; j<a.length; j++) {
            i.next();
            i.set((T)a[j]);
        }
    }

    private static void sort(Object[] a, int lo, int hi) {
        if(hi <= lo){
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);// sort left part
        sort(a, mid+1, hi); // sort right part
        merge(a, lo, mid, hi);
    }

    private static void merge(Object[] a, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        System.arraycopy(a, lo, temp, lo, hi + 1 - lo);
        for(int k = lo;k <= hi; k++){
            if (i > mid) a[k] = temp[j++];
            else if (j > hi ) a[k] = temp[i++];
            else if (((Comparable)temp[j]).compareTo(temp[i]) <= -1) a[k] = temp[j++];
            else a[k] = temp[i++];
        }
    }
}
