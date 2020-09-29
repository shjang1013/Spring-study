package com.sohyeon.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class JDBCTest {
    static {
        try {
            Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try(Connection con = DriverManager.getConnection(
                "jdbc:log4jdbc:mysql://127.0.0.1:3306/springdb?useSSL=false&serverTimezone=UTC", "spring", "!")) {
            log.info(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// JDBC 드라이버가 정상적으로 추가되었고, 데이터베이스의 연결이 가능한지 테스트 코드를 작성한다