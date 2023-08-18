package com.example.boardsj.controller;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.PageResponseDTO;
import com.example.boardsj.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardController {

    private final BoardService boardService;

    // 게시판 목록
    @GetMapping("list")
    public void boardList (PageRequestDTO pageRequestDTO, Model model) {

        // 페이지 요청에 따른 게시판 목록과 전체 게시물 수를 PageResponseDTO<BoardDTO>객체로 반환해 list라는 변수에 담음
        PageResponseDTO<BoardDTO> list = boardService.boardList(pageRequestDTO);

        //  model에 boardList라는 이름으로 추가
        model.addAttribute("boardList", list);
    }

    // 게시판 등록
    // get
    @GetMapping("regist")
    public void boardRegistGet() {
        log.info("GET Regist..................");
    }

    // post
    @PostMapping("regist")
    public String boardRegistPost(BoardDTO boardDTO) {

        boardService.regist(boardDTO);

        return "redirect:/board/list";

    }

    // 게시판 조회
    @GetMapping("read/{bno}")
    public String boardRead(@PathVariable("bno") Long bno, Model model) {
        log.info("GET Read.........");

        // tno 조회
        BoardDTO boardDTO = boardService.read(bno);

        // model로 전달
        model.addAttribute("read", boardDTO);

        return "/board/read";

    }

    // 게시판 삭제
    @PostMapping("delete/{bno}")
    public String boardDelete(@PathVariable("tno") Long bno) {

        boardService.delete(bno);

        return "redirect:/board/list";
    }

    // 게시판 수정
    // get
    @GetMapping("modify/{bno}")
    public String boardModifyGet(@PathVariable("bno") Long bno, Model model) {

        log.info("GET modify.........................");

        BoardDTO boardDTO = boardService.read(bno);
        model.addAttribute("board", boardDTO);

        return "/board/modify";
    }

    // post
    @PostMapping("modify")
    public String boardModifyPost(BoardDTO boardDTO) {

        boardService.modify(boardDTO);

        log.info(boardDTO.getBno());

        return "redirect:/board/read/" + boardDTO.getBno();
    }





}
