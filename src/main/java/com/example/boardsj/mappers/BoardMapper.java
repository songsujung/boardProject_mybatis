package com.example.boardsj.mappers;

import com.example.boardsj.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 목록
    List<BoardDTO> boardList(BoardDTO boardDTO);




}
