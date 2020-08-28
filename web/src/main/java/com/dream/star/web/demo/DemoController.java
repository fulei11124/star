package com.dream.star.web.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

    @GetMapping("hello")
    public String Hello(){
        return "hello word!";
    }
}
