package com.sohyeon.service;

import static org.junit.Assert.assertNotNull;

import com.sohyeon.domain.BoardVO;
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
public class BoardServiceTest {

    @Setter(onMethod_ = { @Autowired })
    private BoardService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }  // BoardService 객체가 제대로 주입이 가능한지 확인하는 작업으로 시작

    @Test
    public void testRegister() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newWriter");

        service.register(board);

        log.info("생성된 게시물의 번호 : " + board.getBno());
    }

    @Test
    public void testGetList() {
        service.getList().forEach(board -> log.info(board));
    }  // 현재 테이블에 저장된 모든 데이터를 가져옴

    @Test
    public void testGet() {
        log.info(service.get(1L));
    }

    @Test
    public void testUpdate() {
        BoardVO board = service.get(1L);

        if (board == null) {
            return;
        }

        board.setTitle("제목 수정합니다");
        log.info("MODIFY RESULT: " + service.modify(board));
    }

    @Test
    public void testDelete() {
        log.info("REMOVE RESULT: " + service.remove(2L));
    }
}
