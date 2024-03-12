package org.adrian.com.spring.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/random")
public class RandomDataController {
    Random random = new Random();

    @GetMapping("/getTable")
    public int[] randomIntTable(@RequestParam(name = "size") int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(100) + 1;
        }
        return result;
    }

}