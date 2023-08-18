package com.example.boardsj.mapper;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.mappers.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class BoardMapperTest {

    // BoardMapper 의존성 주입
    @Autowired(required = false) // 의존성이 없을 때에 예외를 발생시키지 않기 위함
    private BoardMapper boardMapper;

    // 목록
    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        log.info("=====================================");
        log.info(boardMapper.boardList(pageRequestDTO));
    }

    // 등록
    @Test
    @Transactional
    public void testRegist() {
        BoardDTO dto = BoardDTO.builder()
                .title("title")
                .content("content")
                .writer("writer")
                .build();

        log.info("=====================================");
        boardMapper.regist(dto);
    }

    // 조회
    @Test
    public void testRead() {

        log.info("=====================================");
        log.info(boardMapper.read(375L));
    }

    // 삭제
    @Test
    @Transactional
    public void testDelete() {

        log.info("=====================================");
        boardMapper.delete(375L);
        log.info("삭제되었습니다.");
    }

    // 수정
    @Test
    public void testModify() {
        BoardDTO dto = BoardDTO.builder()
                .bno(375L)
                .title("testModify")
                .content("test0331")
                .build();

        boardMapper.modify(dto);
    }


}
