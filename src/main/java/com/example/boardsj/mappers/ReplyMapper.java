package com.example.boardsj.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.ReplyDTO;

public interface ReplyMapper {

    // list
    List<ReplyDTO> getList(
        @Param("bno") Integer bno, @Param("pr") PageRequestDTO pageRequestDTO
    );
    
    // total
    int getBnoCount(Integer bno);

    // register
    // 댓글(gno가 0일 때 실행)
    int registerReply(ReplyDTO replyDTO);
    // 댓글의 gno 업데이트
    int updateReplyGno(Integer rno);
    // 대댓글(gno가 0이 아닐 때 실행)
    int registerReplyChild(ReplyDTO replyDTO);

}
