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


}
