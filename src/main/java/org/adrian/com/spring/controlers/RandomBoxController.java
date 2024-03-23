package org.adrian.com.spring.controlers;

import org.adrian.com.spring.models.Box;
import org.adrian.com.spring.services.generators.BoxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/box")
public class RandomBoxController {

    BoxService boxService;
    public RandomBoxController() {
        boxService = new BoxService();
    }

    @GetMapping("/randomBox")
    public ResponseEntity<Box> randomBox() {
        return new ResponseEntity<>(boxService.createRandomBox(), HttpStatus.OK);
    }
}
