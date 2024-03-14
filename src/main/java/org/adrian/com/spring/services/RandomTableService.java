package org.adrian.com.spring.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomTableService {
    Random random = new Random();
    public int[] getTable(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(100) + 1;
        }
        return result;
    }
}