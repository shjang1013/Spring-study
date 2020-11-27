package com.sohyeon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  // 모든 필드에 대한 생성자를 자동으로 생성
@NoArgsConstructor   // 파라미터가 없는 생성자를 자동으로 생성
public class SampleVO {

    private Integer mno;
    private String firstName;
    private String lastName;
}
