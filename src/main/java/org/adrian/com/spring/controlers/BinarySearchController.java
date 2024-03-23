package org.adrian.com.spring.controlers;

import org.adrian.com.spring.services.algorithms.BinarySearchService;
import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.models.BinarySearchRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/binarySearch")
public class BinarySearchController {

    BinarySearchService binarySearchService;

    public BinarySearchController() {
        binarySearchService = new BinarySearchService();
    }

    @GetMapping("/table")
    public ResponseEntity<int[]> getTable(@RequestParam(name = "size") int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/search")
    @ResponseBody
    public ResponseEntity<AlgorithmsResult> binarySearch(@RequestBody BinarySearchRequest request) {
        AlgorithmsResult algorithmsResult = binarySearchService.search(request.array(), request.expected());
        return new ResponseEntity<>(algorithmsResult, HttpStatus.OK);
    }
}