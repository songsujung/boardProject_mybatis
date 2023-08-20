package com.example.boardsj.mapper;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.ReplyDTO;
import com.example.boardsj.mappers.ReplyMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyMapperTest {

    @Autowired(required = false)
    private ReplyMapper replyMapper;

    // 목록
    @Test
    public void testReplyList() {
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

    // 댓글 등록
    //test rallback이 default, commit 설정
    @Test
    @Transactional
    //@Commit
    public void testReplyRegister() {
        // replyDTO
        ReplyDTO replyDTO = ReplyDTO.builder()
        .bno(375)
        .reply("Reply Mapper Test")
        .replyer("Reply Mapper Test")
        .build();

        log.info("===========================");
        log.info("===========================");

        int insertCount = replyMapper.registerReply(replyDTO);

        // 예외처리
        Assertions.assertEquals(insertCount, 1);
        
        if(insertCount != 1){
        throw new RuntimeException("INSERT FAIL");
        }

        Integer rno = replyDTO.getRno();
        log.info("rno: " + rno);

        replyMapper.updateReplyGno(rno);
    }

    // 대댓글 등록
    //test rallback이 default, commit 설정
    @Test
    @Transactional
    //@Commit
    public void testReplyRegisterChild() {
        // replyDTO
        ReplyDTO replyDTO = ReplyDTO.builder()
        .bno(375)
        .reply("Reply Mapper Test")
        .replyer("Reply Mapper Test")
        .gno(2)
        .build();

        log.info("===========================");
        log.info("===========================");

        int insertCount = replyMapper.registerReplyChild(replyDTO);

        // 예외처리
        Assertions.assertEquals(insertCount, 1);
        
        if(insertCount != 1){
        throw new RuntimeException("INSERT FAIL");
        }
    }

    // 댓글 조회
    @Test
    public void testReadOne(){
        Integer rno = 2;

        log.info("===========================");
        log.info("===========================");
        log.info(replyMapper.readOne(rno));
    }

    // 댓글 삭제
    @Test
    @Transactional
    public void testReplyDelete(){
        Integer rno = 9;

        log.info("===========================");
        log.info("===========================");
        replyMapper.delete(rno);
    }

    // 댓글 수정
    @Test
    @Transactional
    //@Commit
    public void testReplyModify(){
        ReplyDTO replyDTO = ReplyDTO.builder()
        .rno(3)
        .reply("reply modify")
        .build();

        log.info("===========================");
        log.info("===========================");
        replyMapper.modify(replyDTO);
    }
    
}
