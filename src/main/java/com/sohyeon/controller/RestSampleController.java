package com.sohyeon.controller;

import com.sohyeon.domain.SampleVO;
import com.sohyeon.domain.Ticket;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/restSample")
@Log4j
public class RestSampleController {

    @GetMapping(value="/getText", produces="text/plain; charset=UTF-8")  // 단순 문자열 반환
    public String getText() {
        log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);

        return "안녕하세요";

        // @Controller는 문자열을 반환하는 경우에는 JSP 파일의 이름으로 처리하지만, @RestController의 경우에는 순수한 데이터가 된다.
    }

    @GetMapping(value="/getSample", produces={MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})  // 객체의 반환
    public SampleVO getSample() {
        return new SampleVO(112, "스타", "로드");
    }

    @GetMapping(value="/getSample2")
    public SampleVO getSample2() {
        return new SampleVO(113, "로켓", "라쿤");
    }

    @GetMapping(value="/getList")  // 컬렉션 타입의 객체 반환
    public List<SampleVO> getList() {
        return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+" First", i+" Last")).collect(Collectors.toList());
    }

    @GetMapping(value="/getMap")
    public Map<String, SampleVO> getMap() {
        Map<String, SampleVO> map = new HashMap<>();
        map.put("First", new SampleVO(111, "그루트", "주니어"));

        return map;
    }

    @GetMapping(value="/check", params={"height", "weight"})
    public ResponseEntity<SampleVO> check(Double height, Double weight) {
        SampleVO vo = new SampleVO(0, ""+height, ""+weight);

        ResponseEntity<SampleVO> result = null;

        if (height < 150) {
            result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo); // ResponseEntity는 데이터와 함께 HTTP 헤더의 상태 메시지 등을 같이 전달하는 용도로 사용한다.
        } else {
            result = ResponseEntity.status(HttpStatus.OK).body(vo);
        }

        return result;
    }

    @GetMapping("/product/{cat}/{pid}")
    public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
        return new String[] {"category: " + cat, "productid: " + pid};
    }

    @PostMapping("/ticket")  //  @PostMapping : @RequestBody가 말 그대로 요청한 내용을 처리하기 때문에
    public Ticket convert(@RequestBody Ticket ticket) {
        log.info("convert.....ticket" + ticket);

        return ticket;
    }
}
