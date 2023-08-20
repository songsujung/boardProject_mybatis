package com.example.boardsj.service.reply;

import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.PageResponseDTO;
import com.example.boardsj.dto.ReplyDTO;

public interface ReplyService {
    
    // 목록
    PageResponseDTO<ReplyDTO> getList(Integer bno, PageRequestDTO pageRequestDTO);

    // 댓글 등록
    Integer register(ReplyDTO replyDTO);

    // 댓글 조회
    ReplyDTO readOne(Integer rno);

    // 댓글 삭제
    void delete(Integer rno);

    // 댓글 수정
    void modify(ReplyDTO replyDTO);

}
