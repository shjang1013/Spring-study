package com.sohyeon.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class SampleController {

    @GetMapping("/")
    public String doA() {
        return "index";
    }
}
