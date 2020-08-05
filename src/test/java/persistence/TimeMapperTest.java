package persistence;

import com.sohyeon.mapper.TimeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.sohyeon.config.RootConfig.class})
@Log4j
public class TimeMapperTest {

    @Setter(onMethod_ = @Autowired)
    private TimeMapper timeMapper;

    @Test
    public void testGetTime() {
        log.info(timeMapper.getClass().getName()); // 실제 동작하는 클래스의 이름을 확인해 주는데 실행 결과를 보면 개발 시 인터페이스만 만들어 주었는데 내부적으로 적당한 클래스가 만들어진 것을 확인할 수 있다.
        log.info(timeMapper.getTime());
    } // Mapper 인터페이스에 어노테이션을 사용해서 구현

    @Test
    public void testGetTime2() {
        log.info("getTime2");
        log.info(timeMapper.getTime2());
    } // Mapper.xml로 구현
}

// TimeMapper가 정상적으로 사용이 가능한 지를 알아 보기 위한 테스트 코드로, 위의 코드가 정상적으로 동작한다면 스프링 내부에는 TimeMapper 타입으로 만들어진 스프링 객체(빈)가 존재한다는 뜻이 된다.