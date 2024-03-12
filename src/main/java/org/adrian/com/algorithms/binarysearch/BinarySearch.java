package org.adrian.com.algorithms.binarysearch;

import org.adrian.com.utils.Counter;

public class BinarySearch {
    private final BinarySearchResult result = new BinarySearchResult();

    public BinarySearch() {
        //TODO I think I will create FE for this and this description will be included there.
        result.setDescription("Binary Search algorithm characterise with really fast searching time. " +
                "This algorithm can drastically short processing time. " +
                "Important! Binary search algorithm has to be used on sorted table");
    }

    public BinarySearchResult search(int[] list, int expected) {
        Counter counter = new Counter();
        int low = 0;
        int high = list.length - 1;
        int iterations = 1;
        counter.start();
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == expected) {
                result.setTime(counter.stop());
                result.setIterations(iterations);
                result.setResult(mid);
                return result;
            }
            if (guess > expected) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            iterations++;
        }
        result.setTime("Processed in %s microseconds".formatted(counter.stop()));
        result.setIterations(iterations);
        result.setResult(-1);
        return result;
    }
}