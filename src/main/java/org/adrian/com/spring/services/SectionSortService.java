package org.adrian.com.spring.services;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.models.SectionSortSmallestResult;
import org.adrian.com.utils.Counter;
import org.springframework.stereotype.Service;

@Service
public class SectionSortService {
    private SectionSortSmallestResult smallestResult;
    private final AlgorithmsResult result = new AlgorithmsResult();

    public AlgorithmsResult sort(int[] arr) {
        smallestResult = new SectionSortSmallestResult();
        Counter counter = new Counter();
        counter.start();
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            findSmallest(arr);
            int smallestIndex = smallestResult.getResult();
            newArr[i] = arr[smallestIndex];
            arr[smallestIndex] = Integer.MAX_VALUE;
        }
        return result.build(newArr, counter.stop(), smallestResult.getIteration());
    }

    private void findSmallest(int[] arr) {
        int smallest = arr[0];
        int smallestIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
            smallestResult.setIteration(smallestResult.getIteration() + 1);
        }
        smallestResult.setResult(smallestIndex);
    }
}