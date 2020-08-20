package com.sohyeon.persistence;

import com.sohyeon.config.RootConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTest {

    @Setter(onMethod_ = { @Autowired })
    private DataSource dataSource;

    @Setter(onMethod_ = { @Autowired })
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection() {
        try (Connection con = dataSource.getConnection()) {
            log.info(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMyBatis() {
        try (SqlSession session = sqlSessionFactory.openSession();
            Connection con = session.getConnection();
        ) {
             log.info(session);
             log.info(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 빈으로 등록된 DataSource를 이용해서 Connection을 제대로 처리할 수 있는지를 확인해 보는 용도

// SqlSessionFactoryBean을 이용해서 SqlSession을 생성하고, 이를 이용해서 Connection까지 테스트하는 용도