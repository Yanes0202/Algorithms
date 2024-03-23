package org.adrian.com.spring.services.generators;

import org.adrian.com.spring.models.Box;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BoxService {
    private static final int MAX_DEPTH = 4;

    static Random random = new Random();

    public Box createRandomBox() {
        return createBox(0, true);
    }

    public Box createEmptyBox() {
        return createBox(0, false);
    }

    private static Box createBox(int depth, boolean generateKey) {
        if (depth >= MAX_DEPTH) {
            return new Box(new Box[0], false);
        }

        boolean hasKey = generateKey && random.nextInt(10) == 0;

        Box[] boxesInside = new Box[random.nextInt(3) + 1];
        for (int i = 0; i < boxesInside.length; i++) {
            boxesInside[i] = createBox(depth + 1, generateKey);
        }

        return new Box(boxesInside, hasKey);
    }
}