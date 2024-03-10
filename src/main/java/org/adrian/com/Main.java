package org.adrian.com;

import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        for (int i =0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }

        System.out.println(Arrays.toString(array));

        int[] sortedArr = SectionSort.sectionSort(array);

        System.out.println(Arrays.toString(sortedArr));

        System.out.println(BinarySearch.search(sortedArr, sortedArr[1]));

        System.out.println(BinarySearch.search(sortedArr, 8));
    }
}