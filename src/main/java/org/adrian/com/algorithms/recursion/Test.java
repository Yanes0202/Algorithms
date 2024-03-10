package org.adrian.com.algorithms.recursion;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Box box = new Box(0);
        System.out.println(box);
        Stack<Box> stack = new Stack<>();
        stack.push(box);
        System.out.println(Recursion.recursion(stack));
        System.out.println(Recursion.recursionTime);
    }
}
