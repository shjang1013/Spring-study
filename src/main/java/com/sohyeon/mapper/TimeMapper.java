package com.sohyeon.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    @Select("select now()")
    public String getTime();  // @Select("SELECT sysdate FROM dual") : 오라클

    public String getTime2();
}

// TimeMapper 인터페이스에는 MyBatis의 어노테이션을 이용해서 SQL을 메서드에 추가한다.

// Mapper를 작성해 주었다면 MyBatis가 동작할 때 Mapper를 인식할 수 있도록 RootConfig.class에 추가적인 설정이 필요하다