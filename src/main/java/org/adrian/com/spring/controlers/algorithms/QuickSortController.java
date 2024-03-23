package org.adrian.com.spring.controlers.algorithms;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.services.algorithms.QuickSortService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quickSort")
public class QuickSortController {

    QuickSortService quickSortService;

    public QuickSortController() {
        quickSortService = new QuickSortService();
    }

    @PostMapping("/sort")
    public ResponseEntity<AlgorithmsResult> sort(@RequestBody() int[] array) {
        return new ResponseEntity<>(quickSortService.quickSort(array), HttpStatus.OK);
    }
}