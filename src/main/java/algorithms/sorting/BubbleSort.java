package algorithms.sorting;

/**
 * Created by Orestis on 14/01/2015
 */
public final class BubbleSort {
    public static void sortArray(int[] array){
        for(int k = 0; k < array.length; k++) {
            for (int i = 0; i < array.length-1; i++) {
                if (array[i + 1] < array[i]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }
}
