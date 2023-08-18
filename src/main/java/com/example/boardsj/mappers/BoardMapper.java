package com.example.boardsj.mappers;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 목록
    List<BoardDTO> boardList(PageRequestDTO pageRequestDTO);

    // 등록
    int regist(BoardDTO boardDTO);

    // 조회
    BoardDTO read(Long bno);

    // 삭제
    int delete(Long bno);

    // 수정
    int modify(BoardDTO boardDTO);

    // total
    int total(PageRequestDTO pageRequestDTO);




}
