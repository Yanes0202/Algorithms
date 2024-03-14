package org.adrian.com.spring.controlers;

import org.adrian.com.spring.services.RandomTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class RandomDataController {
    @Autowired
    RandomTableService randomTableService;

    @GetMapping("/getTable")
    public int[] randomIntTable(@RequestParam(name = "size") int size) {
        return randomTableService.getTable(size);
    }
}