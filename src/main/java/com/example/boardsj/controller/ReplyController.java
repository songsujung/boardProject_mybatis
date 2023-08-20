package com.example.boardsj.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.PageResponseDTO;
import com.example.boardsj.dto.ReplyDTO;
import com.example.boardsj.service.reply.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/replies/")
public class ReplyController {

    // 의존성 주입
    private final ReplyService replyService;

    // 목록
    // produces : Content-Type을 지정 (JSON 형식)
    @GetMapping(value = "{bno}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponseDTO<ReplyDTO> getlist(@PathVariable("bno") Integer bno, PageRequestDTO pageRequestDTO) {
        
        log.info("GET | reply List =======================================");

        return replyService.getList(bno, pageRequestDTO);
    }

    // 댓글 등록
    // @RequestBody: 보내는 데이터를 JSON형식으로
    // rno 데이터를 전달하기 위해 return타입을 Map
    @PostMapping("{bno}/register")
    public Map<String, Integer> register(@PathVariable("bno") Integer bno, @RequestBody ReplyDTO replyDTO) {
        log.info("POST | reply Register =======================================");
        
        replyDTO.setBno(bno); // 안전장치

        // rno 설정
        Integer rno = replyService.register(replyDTO);

        return Map.of("result", rno);
    }

    // 댓글 조회
    @GetMapping("read/{rno}")
    public ReplyDTO readOne(
        @PathVariable("rno") Integer rno
    ){
        log.info("GET | reply Read =======================================");

        return replyService.readOne(rno);
    }

    // 댓글 삭제
    @DeleteMapping("delete/{rno}")
    public Map<String, Integer> delete(
        @PathVariable("rno") Integer rno
    ){
        log.info("DELETE | reply Delete =======================================");

        replyService.delete(rno);

        return Map.of("result", rno);
    }

    // 댓글 수정
    @PutMapping("modify/{rno}")
    public Map<String, Integer> modify(
        @RequestBody ReplyDTO replyDTO
    ){
        log.info("PUT | reply Modify =======================================");

        replyService.modify(replyDTO);

        return Map.of("result", replyDTO.getRno());
    }
    
}
