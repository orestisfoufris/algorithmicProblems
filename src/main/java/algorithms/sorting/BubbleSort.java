package algorithms.sorting;

/**
 * Created by Orestis on 14/01/2015
 */
public final class BubbleSort {
    public static void sortArray(int[] array){
        for(int k = array.length-1; k > 0; k--) {
            for (int i = 0; i < k; i++) {
                if (array[i + 1] < array[i]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }
}
