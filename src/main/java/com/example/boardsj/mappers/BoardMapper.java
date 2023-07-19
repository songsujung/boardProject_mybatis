package com.example.boardsj.mappers;

import com.example.boardsj.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 목록
    List<BoardDTO> boardList(BoardDTO boardDTO);

    // 등록
    int regist(BoardDTO boardDTO);

    // 조회
    BoardDTO read(Long tno);

    // 삭제
    int delete(Long tno);

    // 수정
    int modify(BoardDTO boardDTO);




}
