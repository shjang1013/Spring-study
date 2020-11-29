package com.sohyeon.mapper;

import com.sohyeon.domain.Criteria;
import com.sohyeon.domain.ReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {

    // 등록
    public int insert(ReplyVO vo);

    // 조회
    public ReplyVO read(Long rno);

    // 수정
    public int update(ReplyVO reply);

    // 삭제
    public int delete(Long rno);

    // 페이징 처리
    public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);  // MyBatis는 두 개 이상이 데이터를 파라미터로 전달하기 위해 @Param을 이용해서 이름을 사용하는 방식
}
