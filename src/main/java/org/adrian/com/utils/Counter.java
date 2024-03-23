package org.adrian.com.utils;

public class Counter {
    private static long startTime;

    public static void start() {
        startTime = System.nanoTime();
    }

    public static String stop() {
        return "Processed in %s microseconds".formatted((System.nanoTime() - startTime) / 1_000);
    }

    private Counter() {}
}