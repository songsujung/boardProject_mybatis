package com.example.boardsj.service;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    // 목록
    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        log.info("====================================");
        log.info(boardService.boardList(pageRequestDTO));
    }

    // 등록
    @Test
    public void testRegist() {

        BoardDTO boardDTO = BoardDTO.builder()
                .title("title")
                .content("content")
                .writer("sujung")
                .build();

        boardService.regist(boardDTO);
        log.info("====================================");
        log.info("등록 완료");
    }

    // 조회
    @Test
    public void testRead() {

        log.info("====================================");
        log.info(boardService.read(2038L));
    }

    // 삭제
    @Test
    public void testDelete() {

        boardService.delete(1526L);
        log.info("====================================");
        log.info("삭제 완료");
    }

    // 수정
    @Test
    public void testModify() {
        BoardDTO boardDTO = BoardDTO.builder()
                .tno(1525L)
                .title("titleUpdate")
                .content("contentUpdate")
                .build();

        boardService.modify(boardDTO);
        log.info("====================================");
        log.info("수정 완료");
    }
}
