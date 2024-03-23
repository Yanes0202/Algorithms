package org.adrian.com.spring.controlers;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.models.Box;
import org.adrian.com.spring.services.RecursionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayDeque;
import java.util.Deque;

@Controller
@RequestMapping("/recursion")
public class RecursionController {
    RecursionService recursionService;

    public RecursionController() {
        recursionService = new RecursionService();
    }

    @PostMapping("/findKey")
    public ResponseEntity<AlgorithmsResult> recursion(@RequestBody() Box box) {
        Deque<Box> stack = new ArrayDeque<>();
        stack.push(box);
        return new ResponseEntity<>(recursionService.recursion(stack), HttpStatus.OK);
    }

}