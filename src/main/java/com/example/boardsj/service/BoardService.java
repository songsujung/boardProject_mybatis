package com.example.boardsj.service;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.PageResponseDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BoardService {

    // 목록
    PageResponseDTO<BoardDTO> boardList(PageRequestDTO pageRequestDTO);

    // 등록
    void regist(BoardDTO boardDTO);

    // 조회
    BoardDTO read(Long bno);

    // 삭제
    void delete(Long bno);

    // 수정
    void modify(BoardDTO boardDTO);
}
