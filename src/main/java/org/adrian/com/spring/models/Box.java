package org.adrian.com.spring.models;

import lombok.Data;

@Data
public class Box {
    private static final int MAX_DEPTH = 4;

    private final Box[] boxesInside;
    private final boolean key;

    public Box(Box[] boxesInside, boolean key) {
        this.boxesInside = boxesInside;
        this.key = key;
    }
}
