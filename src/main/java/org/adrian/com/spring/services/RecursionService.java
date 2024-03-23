package org.adrian.com.spring.services;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.models.Box;
import org.adrian.com.utils.Counter;
import org.springframework.stereotype.Service;

import java.util.Deque;

@Service
public class RecursionService {

    private static final AlgorithmsResult result = new AlgorithmsResult();
    private int iterations = 1;
    static Counter counter = new Counter();

    public AlgorithmsResult recursion(Deque<Box> stack) {
        counter.start();
        Box checkedBox = stack.pop();
        if (checkedBox.isHasKey()) {
            return result.build(true, counter.stop(), iterations);
        } else {
            for (Box b: checkedBox.getBoxesInside()) {
                stack.push(b);
            }
            iterations++;
            return stack.isEmpty() ? result.build(false, counter.stop(), iterations) : recursion(stack);
        }
    }
}