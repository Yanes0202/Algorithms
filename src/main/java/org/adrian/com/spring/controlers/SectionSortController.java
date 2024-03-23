package org.adrian.com.spring.controlers;

import org.adrian.com.spring.models.AlgorithmsResult;
import org.adrian.com.spring.services.algorithms.SectionSortService;
import org.adrian.com.spring.models.BinarySearchRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sectionSort")
public class SectionSortController {

    SectionSortService sectionSortService;

    public SectionSortController() {
        sectionSortService = new SectionSortService();
    }

    @PostMapping("/sort")
    public ResponseEntity<AlgorithmsResult> sectionSort(@RequestBody() BinarySearchRequest request) {
        return new ResponseEntity<>(sectionSortService.sort(request.array()), HttpStatus.OK);
    }
}