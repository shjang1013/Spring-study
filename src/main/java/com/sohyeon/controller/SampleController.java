package com.sohyeon.controller;

import com.sohyeon.domain.SampleDTO;
import com.sohyeon.domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/ex01")  // 메서드의 리턴 타입을 void로 지정하는 경우 해당 URL의 경로를 그대로 jsp파일의 이름으로 사용함
    public void ex01(TodoDTO todo) {
        log.info("todo: " + todo);
    }

    @GetMapping("/ex02")  // @ModelAttribute : 강제로 전달받은 파라미터를 Model에 담아서 전달하도록 할 때 필요한 어노테이션, 파라미터로 전달된 데이터를 다시 화면에서 사용해야 할 경우에 유용하게 사용됨
    public String ex02(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: "+dto);
        log.info("page: "+page);

        return "/sample/ex02";
    }

    @GetMapping("/ex03")  // 스프링 MVC는 자동으로 브라우저에 JSON 타입으로 객체를 변환해서 전달하게 됨
    public @ResponseBody SampleDTO ex03() {
        log.info("/ex03..........");

        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");

        return dto;
    }
    // 스프링 MVC는 리턴 타입에 맞게 데이터를 변환해 주는 역할을 지정할 수 있는데 기본적으로 JSON은 처리가 되므로 별도의 설정이 필요로 하지 않음
    // @Controller + @ResponseBody = @RestController

    @GetMapping("/ex04")
    public ResponseEntity<String> ex04() {
        log.info("/ex04..........");

        // {"name": "홍길동"}
        String msg = "{\"name\": \"홍길동\"}";

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }
    // ResponseEntity는 HttpHeaders 객체를 같이 전달할 수 있고, 이를 통해서 원하는 HTTP 헤더 메시지를 가공하는 것이 가능하다
    // 브라우저에는 JSON 타입이라는 헤더 메시지와 200 OK라는 상태 코드를 전송한다
}

