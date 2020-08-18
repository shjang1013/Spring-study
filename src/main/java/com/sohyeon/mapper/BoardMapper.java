package com.sohyeon.mapper;

import com.sohyeon.domain.BoardVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {
    // @Select("select * from table_board where bno > 0")
    public List<BoardVO> getList();
}
