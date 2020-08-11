package com.sohyeon.controller;

import com.sohyeon.domain.SampleDTO;
import com.sohyeon.domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

    /*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
    }
    */

    @GetMapping("/basicGet")
    public String doA() {
        return "index";
    }

    @GetMapping("/ex01")
    public String ex01(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: "+dto);
        log.info("page: "+page);

        return "/sample/ex02";
    }
}

// @ModelAttribute : 강제로 전달받은 파라미터를 Model에 담아서 전달하도록 할 때 필요한 어노테이션이다
// 기본 자료형의 경우 파라미터로 선언하더라도 기본적으로 화면까지 전달되지는 않는다.
