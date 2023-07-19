package com.example.boardsj.mapper;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.mappers.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardMapperTest {

    // BoardMapper 의존성 주입
    @Autowired(required = false) // 의존성이 없을 때에 예외를 발생시키지 않기 위함
    private BoardMapper boardMapper;

    // 목록
    @Test
    public void testList() {
        BoardDTO dto = BoardDTO.builder().build();

        log.info("=====================================");
        log.info(boardMapper.boardList(dto));
    }

    // 등록
    @Test
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
        log.info(boardMapper.read(2038L));
    }

    // 삭제
    @Test
    public void testDelete() {

        log.info("=====================================");
        boardMapper.delete(1L);
        log.info("삭제되었습니다.");
    }

    // 수정
    @Test
    public void testModify() {
        BoardDTO dto = BoardDTO.builder()
                .tno(2038L)
                .title("testModify")
                .content("test0331")
                .build();

        boardMapper.modify(dto);
    }


}
