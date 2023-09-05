package com.example.boardsj.service;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.PageResponseDTO;
import com.example.boardsj.mappers.BoardMapper;
import com.example.boardsj.mappers.FileUploadMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final로 생성된 객체를 초기화 해주기 위해 자동으로 생성자 주입
public class BoardServiceImpl implements BoardService {

    // 의존성 주입
    private final BoardMapper boardMapper;
    private final FileUploadMapper fileUploadMapper;

    // 목록
    @Override
    public PageResponseDTO<BoardDTO> boardList(PageRequestDTO pageRequestDTO) {

        // 리스트
        List<BoardDTO> boardList = boardMapper.boardList(pageRequestDTO);

        // total
        int total = boardMapper.total(pageRequestDTO);

        // BoardDTO 타입의 list, total값을 가진 PageResponseDTO객체를 반환
        return PageResponseDTO.<BoardDTO>withAll()
                .list(boardList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

    }

    // 등록
    @Override
    public void regist(BoardDTO boardDTO) {

        boardMapper.regist(boardDTO);
    }

    // 조회
    @Override
    public BoardDTO read(Long bno) {

        return boardMapper.read(bno);
    }

    // 삭제
    @Override
    public void delete(Long bno) {

        boardMapper.delete(bno);
    }

    // 수정
    @Override
    public void modify(BoardDTO boardDTO) {

        boardMapper.modify(boardDTO);

    }
}
