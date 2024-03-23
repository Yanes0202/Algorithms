package org.adrian.com.spring.services.algorithms;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.springframework.stereotype.Service;

@Service
public class BinarySearchService extends AbstractService {

    public AlgorithmsResult search(int[] list, int expected) {
        counter.start();
        iterations = 1;
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == expected) {
                return AlgorithmsResult.build(mid, counter.stop(), iterations);
            }
            if (guess > expected) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            iterations++;
        }
        return AlgorithmsResult.build(-1, counter.stop(), iterations);
    }
}