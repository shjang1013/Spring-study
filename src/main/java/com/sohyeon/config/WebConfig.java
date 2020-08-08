package com.sohyeon.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }
    // <context-param>에는 root-context.xml의 경로가 설정되어 있음

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ServletConfig.class };
    }
    //

    @Override
    protected String[] getServletMappings() { return new String[] { "/" }; }
}

// web.xml은 Tomcat 구동과 관련된 설정으로, web.xml을 이용해서 스프링 구동