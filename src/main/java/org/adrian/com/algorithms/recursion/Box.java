package org.adrian.com.algorithms.recursion;

import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@ToString
@Getter
public class Box {
    private static final int MAX_DEPTH = 4;

    private final Box[] boxesInside;
    private final boolean hasKey;

    public Box(int depth) {
        Random random = new Random();

        if (depth < MAX_DEPTH) {
            boxesInside = new Box[random.nextInt(3) + 1];
            hasKey = random.nextInt(10) == 0;

            for (int i = 0; i < boxesInside.length; i++) {
                boxesInside[i] = new Box(depth + 1);
            }
        } else {
            boxesInside = new Box[0];
            hasKey = random.nextInt(10) == 0;
        }
    }
}