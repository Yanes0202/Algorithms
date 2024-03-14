package org.adrian.com.algorithms.recursion;

import java.util.Deque;

public class Recursion {

    private Recursion() {}
    static int recursionTime = 0;

    public static boolean recursion(Deque<Box> stack) {
        recursionTime++;
        Box checkedBox = stack.pop();
        if (checkedBox.isHasKey()) {
            return true;
        } else {
            for (Box b: checkedBox.getBoxesInside()) {
                stack.push(b);
            }
            return recursion(stack);
        }
    }
}