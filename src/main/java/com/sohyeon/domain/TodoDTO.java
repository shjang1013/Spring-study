package com.sohyeon.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TodoDTO {

    private String title;

    @DateTimeFormat(pattern = "yyyy/MM/dd") // 문자열의 형식이 맞다면 자동으로 날짜 타입으로 변환
    private Date dueDate;
}
