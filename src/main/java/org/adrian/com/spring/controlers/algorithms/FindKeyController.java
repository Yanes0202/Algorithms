package org.adrian.com.spring.controlers.algorithms;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.models.Box;
import org.adrian.com.spring.services.algorithms.FindKeyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayDeque;
import java.util.Collections;

@Controller
@RequestMapping("/findKey")
public class FindKeyController {
    FindKeyService recursionService;

    public FindKeyController() {
        recursionService = new FindKeyService();
    }

    @PostMapping("/recursion")
    public ResponseEntity<AlgorithmsResult> recursion(@RequestBody() Box box) {
        return new ResponseEntity<>(recursionService.lookForKeyRecursion(new ArrayDeque<>(Collections.singleton(box))), HttpStatus.OK);
    }

    @PostMapping("/loop")
    public ResponseEntity<AlgorithmsResult> useLoop(@RequestBody() Box box) {
        return new ResponseEntity<>(recursionService.lookForKeyWhile(new ArrayDeque<>(Collections.singleton(box))), HttpStatus.OK);
    }
}