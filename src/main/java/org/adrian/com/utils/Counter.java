package org.adrian.com.utils;

public class Counter {
    private long startTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public String stop() {
        return "Processed in %s microseconds".formatted((System.nanoTime() - startTime) / 1_000);
    }
}