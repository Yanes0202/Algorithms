package org.adrian.com.spring.controlers;

import org.adrian.com.algorithms.sectionsort.SectionSort;
import org.adrian.com.spring.models.BinarySearchRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sectionSort")
public class SectionSortController {

    @PostMapping("/sort")
    public int[] sectionSort(@RequestBody() BinarySearchRequest request) {
        return SectionSort.sort(request.array());
    }

}