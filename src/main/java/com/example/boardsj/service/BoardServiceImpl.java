package com.example.boardsj.service;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final로 생성된 객체를 초기화 해주기 위해 자동으로 생성자 주입
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    // 목록
    @Override
    public List<BoardDTO> boardList(BoardDTO boardDTO) {

        List<BoardDTO> list = boardMapper.boardList(boardDTO);

        return list;

    }

    // 등록
    @Override
    public void regist(BoardDTO boardDTO) {

        boardMapper.regist(boardDTO);
    }

    // 조회
    @Override
    public BoardDTO read(Long tno) {

        return boardMapper.read(tno);
    }

    // 삭제
    @Override
    public void delete(Long tno) {

        boardMapper.delete(tno);
    }

    // 수정
    @Override
    public void modify(BoardDTO boardDTO) {

        boardMapper.modify(boardDTO);
    }
}
