package org.adrian.com.spring.services;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.utils.Counter;
import org.springframework.stereotype.Service;

@Service
public class BinarySearchService {

    public AlgorithmsResult search(int[] list, int expected) {
        AlgorithmsResult result = new AlgorithmsResult();
        Counter counter = new Counter();
        counter.start();
        int low = 0;
        int high = list.length - 1;
        int iterations = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == expected) {
                return result.build(mid, counter.stop(), iterations);
            }
            if (guess > expected) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            iterations++;
        }
        return result.build(-1, counter.stop(), iterations);
    }
}