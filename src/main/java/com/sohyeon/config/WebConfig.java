package com.sohyeon.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ServletConfig.class };
    }
    @Override
    protected String[] getServletMappings() { return new String[] { "/" }; }
}

// web.xml을 이용해서 스프링 구동
// XML을 사용하지 않는 경우에는 WebConfig 클래스를 작성해서 처리