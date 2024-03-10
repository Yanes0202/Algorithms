package org.adrian.com.algorithms.binary_search;

public class BinarySearch {
    private BinarySearch(){}

    public static int search(int[] list, int expected) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == expected) {
                return mid;
            }
            if (guess > expected) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}