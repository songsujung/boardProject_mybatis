package com.example.boardsj.controller;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    // 목록
    @GetMapping("/list")
    public void list (BoardDTO boardDTO, Model model) {

        List<BoardDTO> list = boardService.boardList(boardDTO);

        model.addAttribute("boardList", list);
    }

}
