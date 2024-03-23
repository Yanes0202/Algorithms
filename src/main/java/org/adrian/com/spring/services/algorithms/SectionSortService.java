package org.adrian.com.spring.services.algorithms;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.utils.Counter;
import org.springframework.stereotype.Service;

@Service
public class SectionSortService {
    private Integer iterations;

    public AlgorithmsResult sort(int[] arr) {
        Counter.start();
        iterations = 0;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = findSmallest(arr);
            newArr[i] = arr[smallestIndex];
            arr[smallestIndex] = Integer.MAX_VALUE;
        }
        return AlgorithmsResult.build(newArr, Counter.stop(), iterations);
    }

    private int findSmallest(int[] arr) {
        int smallest = arr[0];
        int smallestIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
            iterations++;
        }
        return smallestIndex;
    }
}