package sample;

import com.sohyeon.sample.Restaurant;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sohyeon.config.RootConfig.class })
@Log4j
public class SampleTests {

    @Setter(onMethod_ = { @Autowired })
    private Restaurant restaurant;

    @Test
    public void testExist() {
        assertNotNull(restaurant);

        log.info(restaurant);
        log.info("-----------------------------------");
        log.info(restaurant.getChef());
    }
}

// SampleTests 클래스는 spring-test 모듈을 이용해서 스프링을 가동시켜 주입의 동작들이 일어나게 함