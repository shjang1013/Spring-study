package com.sohyeon.controller;

import com.sohyeon.domain.SampleDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

    @GetMapping("/basicOnlyGet")
    public String doA() {
        return "index";
    }

    @GetMapping("/ex")
    public void example(SampleDTO dto) {

        log.info(""+dto);
    }
}
