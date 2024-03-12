package org.adrian.com.algorithms;

import org.adrian.com.algorithms.binarysearch.BinarySearch;
import org.adrian.com.algorithms.sectionsort.SectionSort;

import java.util.Arrays;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = new int[10];
        Random random = new Random();

        for (int i =0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }

//        System.out.println(Arrays.toString(array));

        int[] sortedArr = SectionSort.sort(array);

//        System.out.println(Arrays.toString(sortedArr));
//
//        System.out.println(binarySearch.search(sortedArr, sortedArr[1]));
//
//        System.out.println(binarySearch.search(sortedArr, 8));
    }
}