package com.sohyeon.mapper;

import com.sohyeon.domain.BoardVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {

    // @Select("select * from table_board where bno > 0")
    public List<BoardVO> getList();

    public void insert(BoardVO board);  // useGeneratedKeys, KeyProperty 옵션을 이용해 결과를 리턴받을 수 있음
                                        // mybatis 구문으로 insert를 시도하게 되면, 파라미터로 넘긴 boardVO 객체의 bno값에 insert 했을 때의 key값(bno)이 들어오게 됨
    public BoardVO read(Long bno);

    public int delete(Long bno);

    public int update(BoardVO board);
}
