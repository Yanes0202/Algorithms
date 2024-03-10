package org.adrian.com;

public class BinarySearch {
    private BinarySearch(){}

    public static int search(int[] list, int expected) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int quess = list[mid];
            if (quess == expected) {
                return mid;
            }
            if (quess > expected) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
