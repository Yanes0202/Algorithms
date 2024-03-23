package org.adrian.com.spring.models;

import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@ToString
@Getter
public class Box {
    private static final int MAX_DEPTH = 4;

    private final Box[] boxesInside;
    private final boolean hasKey;
    static Random random = new Random();

    public Box(Box[] boxesInside, boolean hasKey) {
        this.boxesInside = boxesInside;
        this.hasKey = hasKey;
    }
}
