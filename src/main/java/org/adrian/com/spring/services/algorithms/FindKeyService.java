package org.adrian.com.spring.services.algorithms;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.models.Box;
import org.springframework.stereotype.Service;

import java.util.Deque;

@Service
public class FindKeyService extends AbstractService {

    public AlgorithmsResult lookForKeyRecursion(Deque<Box> stack) {
        if(iterations == null) iterations = 1;
        counter.start();
        Box checkedBox = stack.pop();
        if (checkedBox.isKey()) {
            return AlgorithmsResult.build(true, counter.stop(), iterations);
        } else {
            for (Box box: checkedBox.getBoxesInside()) {
                stack.push(box);
            }
            iterations++;
            if (stack.isEmpty()) {
                AlgorithmsResult algorithmsResult = AlgorithmsResult.build(false, counter.stop(), iterations);
                iterations = null;
                return algorithmsResult;
            } else {
                return lookForKeyRecursion(stack);
            }
        }
    }

    public AlgorithmsResult lookForKeyWhile(Deque<Box> stack) {
        iterations = 1;
        counter.start();
        while (!stack.isEmpty()) {
            Box checkedBox = stack.pop();
            if (checkedBox.isKey()) {
                return AlgorithmsResult.build(true, counter.stop(), iterations);
            } else {
                for (Box box : checkedBox.getBoxesInside()) {
                    stack.push(box);
                }
                iterations++;
            }
        }
        return AlgorithmsResult.build(false, counter.stop(), iterations);
    }
}