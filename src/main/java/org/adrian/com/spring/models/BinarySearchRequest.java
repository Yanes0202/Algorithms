package org.adrian.com.spring.models;

import java.util.Arrays;

public record BinarySearchRequest(int[] array, int expected) {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BinarySearchRequest other)) return false;
        return Arrays.equals(this.array, other.array) && this.expected == other.expected;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + Integer.hashCode(expected);
        return result;
    }

    @Override
    public String toString() {
        return "{ array: " + Arrays.toString(array) + ", expected: " + expected + " }";
    }
}