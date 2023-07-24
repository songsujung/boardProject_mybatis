package com.example.boardsj.controller;

import com.example.boardsj.dto.BoardDTO;
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
    public void boardList (BoardDTO boardDTO, Model model) {

        List<BoardDTO> list = boardService.boardList(boardDTO);

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
    @GetMapping("read/{tno}")
    public String boardRead(@PathVariable("tno") Long tno, Model model) {
        log.info("GET Read.........");

        // tno 조회
        BoardDTO boardDTO = boardService.read(tno);

        // model로 전달
        model.addAttribute("read", boardDTO);

        return "/board/read";

    }

    // 게시판 삭제
    @PostMapping("delete/{tno}")
    public String boardDelete(@PathVariable("tno") Long tno) {

        boardService.delete(tno);

        return "redirect:/board/list";
    }

    // 게시판 수정
    // get
    @GetMapping("modify/{tno}")
    public String boardModifyGet(@PathVariable("tno") Long tno, Model model) {

        log.info("GET modify.........................");

        BoardDTO boardDTO = boardService.read(tno);
        model.addAttribute("board", boardDTO);

        return "/board/modify";
    }

    // post
    @PostMapping("modify")
    public String boardModifyPost(BoardDTO boardDTO) {

        boardService.modify(boardDTO);

        log.info(boardDTO.getTno());

        return "redirect:/board/read/" + boardDTO.getTno();
    }





}
