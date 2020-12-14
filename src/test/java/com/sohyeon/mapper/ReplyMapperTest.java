package com.sohyeon.mapper;

import com.sohyeon.domain.Criteria;
import com.sohyeon.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
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
    public void testRead() {
        Long targetRno = 5L;

        ReplyVO vo = mapper.read(targetRno);

        log.info(vo);
    }

    @Test
    public void testUpdate() {
        Long targetRno = 10L;

        ReplyVO vo = mapper.read(targetRno);

        vo.setReply("Update Reply");

        int count = mapper.update(vo);

        log.info("UPDATE COUNT: " + count);
    }

    @Test
    public void testDelete() {
        Long targetRno = 23L;

        mapper.delete(targetRno);
    }

    @Test
    public void testList() {
        Criteria cri = new Criteria();

        List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);

        replies.forEach(reply -> log.info(reply));
    }

    @Test
    public void testMapper() {
        log.info(mapper);
    }

}
