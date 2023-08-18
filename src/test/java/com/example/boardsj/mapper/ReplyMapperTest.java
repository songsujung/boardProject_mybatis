package com.example.boardsj.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.ReplyDTO;
import com.example.boardsj.mappers.ReplyMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyMapperTest {

    @Autowired(required = false)
    private ReplyMapper replyMapper;

    // list
    @Test
    public void  testReplyList() {
        // bno
        Integer bno = 375;
        // list
        PageRequestDTO dto = PageRequestDTO.builder().build();

        log.info(dto);

        log.info("==========================================================");
        log.info("==========================================================");
        List<ReplyDTO>  list = replyMapper.getList(bno, dto);

        log.info(list);
    }
    
}
