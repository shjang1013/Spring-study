package com.sohyeon.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {"com.sohyeon.sample"})
public class RootConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/springdb?useSSL=false&serverTimezone=UTC");
        hikariConfig.setUsername("spring");
        hikariConfig.setPassword("*");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }
}

// @Bean이 선언된 메서드의 실행 결과로 반환된 객체는 스프링의 객체(Bean)으로 등록된다