package org.adrian.com.spring.services.algorithms;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.models.Box;
import org.adrian.com.utils.Counter;
import org.springframework.stereotype.Service;

import java.util.Deque;

@Service
public class FindKeyService {
    private Integer iterations;

    public AlgorithmsResult lookForKeyRecursion(Deque<Box> stack) {
        if(iterations == null) iterations = 1;
        Counter.start();
        Box checkedBox = stack.pop();
        if (checkedBox.isKey()) {
            return AlgorithmsResult.build(true, Counter.stop(), iterations);
        } else {
            for (Box box: checkedBox.getBoxesInside()) {
                stack.push(box);
            }
            iterations++;
            if (stack.isEmpty()) {
                AlgorithmsResult algorithmsResult = AlgorithmsResult.build(false, Counter.stop(), iterations);
                iterations = null;
                return algorithmsResult;
            } else {
                return lookForKeyRecursion(stack);
            }
        }
    }

    public AlgorithmsResult lookForKeyWhile(Deque<Box> stack) {
        iterations = 1;
        Counter.start();
        while (!stack.isEmpty()) {
            Box checkedBox = stack.pop();
            if (checkedBox.isKey()) {
                return AlgorithmsResult.build(true, Counter.stop(), iterations);
            } else {
                for (Box box : checkedBox.getBoxesInside()) {
                    stack.push(box);
                }
                iterations++;
            }
        }
        return AlgorithmsResult.build(false, Counter.stop(), iterations);
    }
}