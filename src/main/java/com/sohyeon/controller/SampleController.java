package com.sohyeon.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j
@Controller
public class SampleController {

    @GetMapping("/")
    public String doA() {
        System.out.println("doA called...........");
        return "index";
    }
}
