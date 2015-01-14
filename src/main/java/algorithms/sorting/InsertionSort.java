package algorithms.sorting;

/**
 * Created by Orestis on 14/01/2015
 */
public class InsertionSort {
    public static void sortArray(int[] array){
        for(int i=1; i< array.length; i++){
            int current = array[i], k=i;
            while(k > 0 && current < array[k-1]){
                array[k] = array[k-1];
                k--;
            }
            array[k] = current;

        }
    }
}
