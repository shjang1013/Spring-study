package com.sohyeon.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {"com.sohyeon.service"})
@MapperScan(basePackages = {"com.sohyeon.mapper"})
public class RootConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        // hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/springdb?useSSL=false&serverTimezone=UTC");
        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        hikariConfig.setJdbcUrl("jdbc:log4jdbc:mysql://127.0.0.1:3306/springdb?useSSL=false&serverTimezone=UTC");
        hikariConfig.setUsername("spring");
        hikariConfig.setPassword("*");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource; // DataSource를 통해 미리 연결을 맺어주고 반환하는 구조를 이용하여 성능 향승을 꾀한다.
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean(); // SqlSessionFactoryBean을 이용해서 스프링에 SqlSessionFactory를 등록한다
        sqlSessionFactory.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }
}

// @Bean이 선언된 메서드의 실행 결과로 반환된 객체는 스프링의 객체(Bean)으로 등록된다

// MyBatis-Spring은 Mapper 인터페이스를 이용해서 실제 SQL 처리가 되는 클래스를 자동으로 생성하며, 개발자들은 인터페이스와 SQL만을 작성하는 방식으로 모든 JDBC 처리를 끝낼 수 있다.

// log4jdbc를 이용하는 경우 JDBC 드라이버와 URL 정보를 수정해야 한다.