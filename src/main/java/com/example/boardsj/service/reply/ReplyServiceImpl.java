package com.example.boardsj.service.reply;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.PageResponseDTO;
import com.example.boardsj.dto.ReplyDTO;
import com.example.boardsj.mappers.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    // 의존성 주입
    private final ReplyMapper replyMapper;
    
    // 목록
    @Override
    public PageResponseDTO<ReplyDTO> getList(Integer bno, PageRequestDTO pageRequestDTO) {
        // 30개씩 불러오기
        pageRequestDTO.setSize(30);

        // total
        int total = replyMapper.getBnoCount(bno);

        // page번호
        int pageNum = pageRequestDTO.getPage();

        // 끝페이지 계산
        if(!pageRequestDTO.isReplyLast()){
        //페이지 넘버에 넣어주기
        pageNum = (int) (Math.ceil(total/(double)pageRequestDTO.getSize()));

        // 페이지번호가 0보다 작거나 같으면 1로 설정
        pageNum = pageNum <= 0 ? 1 : pageNum;
        } // if end

        // 끝페이지 번호로 설정
        pageRequestDTO.setPage(pageNum);

        // list
        List<ReplyDTO> list = replyMapper.getList(bno, pageRequestDTO);

        return PageResponseDTO.<ReplyDTO>withAll()
        .list(list)
        .total(total)
        .pageRequestDTO(pageRequestDTO)
        .build();
    }

    // 댓글, 대댓글 등록
    @Override
    public Integer register(ReplyDTO replyDTO) {
        Integer result = null;
        int gno = replyDTO.getGno();

        // 댓글일 때
        if(gno == 0){
        // 정상 등록 확인을 위한 count
        int count = replyMapper.registerReply(replyDTO); // 댓글이기 때문에 registerReply
        
        // 예외처리(정상 등록이 아닐때)
        if(count != 1){
            throw new RuntimeException("Reply Insert Exception");
        }

        // rno값을 가져온 후 update
        Integer rno = replyDTO.getRno();
        replyMapper.updateReplyGno(rno);
        result = rno;
        }else{
        // 대댓글일 때
        int count = replyMapper.registerReplyChild(replyDTO);
        
        // 예외처리(정상 등록 아닐 때)
        if(count != 1){
            throw new RuntimeException("Reply Insert Exception");
        }

        result = replyDTO.getRno();
        }
        return result;
    }

    // 댓글 조회
    @Override
    public ReplyDTO readOne(Integer rno) {
        return replyMapper.readOne(rno);
    }

    // 댓글 삭제
    @Override
    public void delete(Integer rno) {
        replyMapper.delete(rno);
    }

    // 댓글 수정
    @Override
    public void modify(ReplyDTO replyDTO) {
        replyMapper.modify(replyDTO);
    }
    
}
