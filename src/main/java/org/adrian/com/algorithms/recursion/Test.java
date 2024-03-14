package org.adrian.com.algorithms.recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Box box = new Box(0);
        System.out.println(box);
        Deque<Box> stack = new ArrayDeque<>();
        stack.push(box);
        System.out.println(Recursion.recursion(stack));
        System.out.println(Recursion.recursionTime);
    }
}
