package org.adrian.com.spring.services.algorithms;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.utils.Counter;
import org.springframework.stereotype.Service;

@Service
public class BinarySearchService {

    public AlgorithmsResult search(int[] list, int expected) {
        Counter.start();
        int iterations = 1;
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == expected) {
                return AlgorithmsResult.build(mid, Counter.stop(), iterations);
            }
            if (guess > expected) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            iterations++;
        }
        return AlgorithmsResult.build(-1, Counter.stop(), iterations);
    }
}