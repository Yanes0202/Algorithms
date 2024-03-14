package org.adrian.com.spring.controlers;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.services.SectionSortService;
import org.adrian.com.spring.models.BinarySearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sectionSort")
public class SectionSortController {

    @Autowired
    SectionSortService sectionSortService;
    @PostMapping("/sort")
    public AlgorithmsResult sectionSort(@RequestBody() BinarySearchRequest request) {
        return sectionSortService.sort(request.array());
    }
}