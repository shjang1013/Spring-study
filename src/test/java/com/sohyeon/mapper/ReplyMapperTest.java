package com.sohyeon.mapper;

import com.sohyeon.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.sohyeon.config.RootConfig.class})
@Log4j
public class ReplyMapperTest {

    private Long[] bnoArr = { 212992L, 212991L, 212990L, 212989L, 212988L};

    @Setter(onMethod_ = @Autowired)
    public ReplyMapper mapper;

    @Test
    public void testCreate() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            ReplyVO vo = new ReplyVO();

            // 게시물의 번호
            vo.setBno(bnoArr[i % 5]);
            vo.setReply("댓글 테스트 " + i);
            vo.setReplyer("replyer" + i);

            mapper.insert(vo);
        });
    }

    @Test
    public void testMapper() {
        log.info(mapper);
    }

}
