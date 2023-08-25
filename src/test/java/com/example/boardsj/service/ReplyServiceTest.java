package com.example.boardsj.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.ReplyDTO;
import com.example.boardsj.service.reply.ReplyService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyServiceTest {

    // 의존성 주입
    @Autowired
    private ReplyService replyService;

    // 목록
    @Test
    public void testGetList(){
        //bno
        Integer bno = 375;
        //list
        PageRequestDTO dto = PageRequestDTO.builder().build();
        
        log.info("====================================");
        log.info("====================================");
        log.info(replyService.getList(bno, dto));
    }

    // 댓글 등록
    @Test
    @Transactional
    public void testRegisterReply(){
        ReplyDTO replyDTO = ReplyDTO.builder()
        .bno(375)
        .reply("Reply Service Test")
        .replyer("Reply Service Replyer")
        .build();

        log.info("====================================");
        log.info("====================================");
        log.info(replyService.register(replyDTO));
    }

    // 대댓글 등록
    @Test
    @Transactional
    public void testRegisterReplyChild(){
        ReplyDTO replyDTO = ReplyDTO.builder()
        .bno(375)
        .gno(13)
        .reply("Reply Child Service Test")
        .replyer("Reply Child Service Replyer")
        .build();

        log.info("====================================");
        log.info("====================================");
        log.info(replyService.register(replyDTO));
    }

    // 댓글 조회
    @Test
    public void testReadOne(){
        Integer rno = 13;

        log.info("====================================");
        log.info("====================================");
        log.info(replyService.readOne(rno));
    }

    // 댓글 삭제
    @Test
    @Transactional
    public void testReplyDelete(){
        Integer rno = 13;

        log.info("====================================");
        log.info("====================================");
        replyService.delete(rno);
    }

    // 댓글 수정
    @Test
    public void testReplyModify(){
        ReplyDTO replyDTO = ReplyDTO.builder()
        .rno(4)
        .reply("reply modify")
        .build();

        log.info("====================================");
        log.info("====================================");
        replyService.modify(replyDTO);
    }
    
}
