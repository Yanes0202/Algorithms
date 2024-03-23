package org.adrian.com.spring.controlers;

import org.adrian.com.spring.services.RandomTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class RandomDataController {
    RandomTableService randomTableService;

    public RandomDataController() {
        randomTableService = new RandomTableService();
    }

    @GetMapping("/table")
    public ResponseEntity<int[]> randomIntTable(@RequestParam(name = "size") int size) {
        return new ResponseEntity<>(randomTableService.getTable(size), HttpStatus.OK);
    }
}