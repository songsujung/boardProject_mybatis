package com.example.boardsj.service;

import com.example.boardsj.dto.BoardDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BoardService {

    // 목록
    List<BoardDTO> boardList(BoardDTO boardDTO);

    // 등록
    void regist(BoardDTO boardDTO);

    // 조회
    BoardDTO read(Long tno);

    // 삭제
    void delete(Long tno);

    // 수정
    void modify(BoardDTO boardDTO);
}
