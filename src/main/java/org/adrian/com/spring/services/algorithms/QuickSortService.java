package org.adrian.com.spring.services.algorithms;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.utils.Counter;
import org.springframework.stereotype.Service;

@Service
public class QuickSortService {

    public AlgorithmsResult quickSort(int[] arr) {
        Counter.start();
        int iterations = 1;
        if (arr.length < 2) {
            return AlgorithmsResult.build(arr, Counter.stop(), iterations);
        } else {
            int pivot = arr[0];
            int[] less = new int[arr.length];
            int[] greater = new int[arr.length];
            int lessIndex = 0;
            int greaterIndex = 0;
            for (int i = 1; i < arr.length; i++) {
                iterations++;
                if (pivot <= arr[i]) {
                    greater[greaterIndex++] = arr[i];
                } else {
                    less[lessIndex++] = arr[i];
                }
            }
            int[] sortedLess = new int[lessIndex];
            System.arraycopy(less, 0, sortedLess, 0, lessIndex);
            int[] sortedGreater = new int[greaterIndex];
            System.arraycopy(greater, 0, sortedGreater, 0, greaterIndex);
            AlgorithmsResult lessResult = quickSort(sortedLess);
            AlgorithmsResult greaterResult = quickSort(sortedGreater);
            return AlgorithmsResult.build(mergeArrays((int[]) lessResult.getResult(), pivot, (int[]) greaterResult.getResult()), Counter.stop(), iterations);
        }
    }

    private int[] mergeArrays(int[] less, int pivot, int[] greater) {
        int[] result = new int[less.length + 1 + greater.length];
        System.arraycopy(less, 0, result, 0, less.length);
        result[less.length] = pivot;
        System.arraycopy(greater, 0, result, less.length + 1, greater.length);
        return result;
    }
}