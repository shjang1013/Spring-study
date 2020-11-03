package com.sohyeon.service;

import com.sohyeon.domain.BoardVO;
import com.sohyeon.domain.Criteria;

import java.util.List;

public interface BoardService {

    // 등록 작업의 구현
    public void register(BoardVO board);

    // 목록(리스트) 작업의 구현
    public List<BoardVO> getList();

    public List<BoardVO> getList(Criteria cri);

    // 조회 작업의 구현
    public BoardVO get(Long bno);

    // 수정/삭제 구현
    public boolean modify(BoardVO board);

    public boolean remove(Long bno);
}
