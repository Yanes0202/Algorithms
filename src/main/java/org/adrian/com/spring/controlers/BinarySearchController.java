package org.adrian.com.spring.controlers;

import org.adrian.com.spring.services.BinarySearchService;
import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.models.BinarySearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/binarySearch")
public class BinarySearchController {
    @Autowired
    BinarySearchService binarySearchService;
    @GetMapping("/getTable")
    public int[] getTable(@RequestParam(name = "size") int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    @PostMapping("/search")
    public AlgorithmsResult binarySearch(@RequestBody BinarySearchRequest request) {
        return binarySearchService.search(request.array(), request.expected());
    }
}