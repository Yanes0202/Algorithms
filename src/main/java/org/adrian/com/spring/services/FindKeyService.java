package org.adrian.com.spring.services;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.models.Box;
import org.adrian.com.utils.Counter;
import org.springframework.stereotype.Service;

import java.util.Deque;

@Service
public class FindKeyService {

    private static final AlgorithmsResult result = new AlgorithmsResult();
    private Integer iterations;
    static Counter counter = new Counter();

    public AlgorithmsResult lookForKeyRecursion(Deque<Box> stack) {
        if(iterations == null) iterations = 1;
        counter.start();
        Box checkedBox = stack.pop();
        if (checkedBox.isKey()) {
            return result.build(true, counter.stop(), iterations);
        } else {
            for (Box box: checkedBox.getBoxesInside()) {
                stack.push(box);
            }
            iterations++;
            return stack.isEmpty() ? result.build(false, counter.stop(), iterations) : lookForKeyRecursion(stack);
        }
    }

    public AlgorithmsResult lookForKeyWhile(Deque<Box> stack) {
        iterations = 1;
        counter.start();
        while (!stack.isEmpty()) {
            Box checkedBox = stack.pop();
            if (checkedBox.isKey()) {
                return result.build(true, counter.stop(), iterations);
            } else {
                for (Box box : checkedBox.getBoxesInside()) {
                    stack.push(box);
                }
                iterations++;
            }
        }
        return result.build(false, counter.stop(), iterations);
    }
}