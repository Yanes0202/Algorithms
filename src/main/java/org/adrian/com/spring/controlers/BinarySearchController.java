package org.adrian.com.spring.controlers;

import org.adrian.com.algorithms.binarysearch.BinarySearch;
import org.adrian.com.algorithms.binarysearch.BinarySearchResult;
import org.adrian.com.spring.models.BinarySearchRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/binarySearch")
public class BinarySearchController {
    BinarySearch binarySearch = new BinarySearch();
    @GetMapping("/getTable")
    public int[] getTable(@RequestParam(name = "size") int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    @PostMapping("/search")
    public BinarySearchResult binarySearch(@RequestBody BinarySearchRequest request) {
        return binarySearch.search(request.array(), request.expected());
    }
}