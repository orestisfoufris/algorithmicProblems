package algorithms.sorting;

import java.util.List;

/**
 * Created by Orestis on 17/07/2015
 */

public class HeapSort {

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        heapSort(list);
    }


    private static <T extends Comparable<? super T>> void heapSort(List<T> list){
        int heapSize = list.size() - 1;
        buildMaxHeap(list, heapSize);
        for (int i = list.size() - 1; i >= 1; i--) {
            exchange(0, i, list);
            heapSize--;
            maxHeapify(list, 0, heapSize);
        }
    }

    /**
     *
     * Maintain the max-heap property (list[find_parent(i)] >= list[i])
     * If the max-heap property is violated float down list[i]
     */
    private static <T extends Comparable<? super T>> void maxHeapify(List<T> list, int index, int heapSize) {
        int largest = index; // initialise largest to index.

        int left = findLeftIndex(index);
        int right = findRightIndex(index);

        if (left <= heapSize && list.get(left).compareTo(list.get(index)) >= 1) {
            largest = left;
        }

        if (right <= heapSize && list.get(right).compareTo(list.get(largest)) >= 1) {
            largest = right;
        }

        if (largest != index) {
            exchange(index, largest, list);
            maxHeapify(list, largest, heapSize);
        }
    }

    /**
     *
     * This function goes through the remaining nodes of the heap tree and
     * runs maxHeapify on each one.
     */
    private static <T extends Comparable<? super T>> void buildMaxHeap(List<T> list, int heapSize) {
        int start = (int) Math.floor((heapSize / 2));
        for (int i = start; i >= 0; i--) {
            maxHeapify(list, i, heapSize);
        }
    }

    private static <T extends Comparable<? super T>> void exchange(int i, int largest, List<T> array){
        T temp = array.get(largest);
        array.set(largest, array.get(i));
        array.set(i, temp);
    }

    private static int findParentIndex(int index) {
        return (index >> 1) ^ 1;
    }

    private static int findLeftIndex(int index) {
        return (index << 1) ^ 1;
    }

    private static int findRightIndex(int index) {
        return (index << 1) + 2;
    }
}
