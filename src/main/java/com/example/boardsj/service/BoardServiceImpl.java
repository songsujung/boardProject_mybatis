package com.example.boardsj.service;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.PageResponseDTO;
import com.example.boardsj.mappers.BoardMapper;
import com.example.boardsj.mappers.FileUploadMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Log4j2
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

        // 게시판 등록
        int count = boardMapper.regist(boardDTO);
        log.info("insert product count: " + count);

        // 파일이름 List로 가져오기
        List<String> fileNames = boardDTO.getFileNames();

        // 게시판 등록 성공과 파일이 등록되었다면 실행
        if(count > 0 && boardDTO.getFileNames() != null && !boardDTO.getFileNames().isEmpty()){
        //bno 가져오기
        Long bno = boardDTO.getBno();
        log.info("--------------------------------- bno: " + bno);

        AtomicInteger index = new AtomicInteger();

        // 등록된 파일 fileNames에서 추출
        List<Map<String, String>> list = fileNames.stream().map(str -> {
            // uuid 가져오기
            String uuid = str.substring(0, 36);
            // 실제 파일명 가져오기
            String fileName = str.substring(37);

            // return map에 담기
            return Map.of("uuid", uuid, "file_name", fileName, "bno", "" + bno, "ord", "" + index.getAndIncrement());
        }).collect(Collectors.toList());

        log.info("=====================================================================");
        log.info("=====================================================================");
        log.info(list);

        // 파일 등록 실행
        fileUploadMapper.registerImage(list);
        }
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

        // 수정 업데이트
        int count = boardMapper.modify(boardDTO);
        log.info("modify product count: " + count);

        // 기존파일 삭제
        fileUploadMapper.deleteImage(boardDTO.getBno());

        // 파일이름 List로 가져오기
        List<String> fileNames = boardDTO.getFileNames();
        log.info(fileNames);

        // 게시판 등록 성공과 파일이 등록되었다면 실행
        if (count > 0) {
        // bno 가져오기
        Long bno = boardDTO.getBno();
        log.info("--------------------------------- bno: " + bno);

        AtomicInteger index = new AtomicInteger();

        // 등록된 파일 fileNames에서 추출
        List<Map<String, String>> list = fileNames.stream().map(str -> {
            // uuid 가져오기
            String uuid = str.substring(0, 36);
            // 실제 파일명 가져오기
            String fileName = str.substring(37);

            // return map에 담기
            return Map.of("uuid", uuid, "file_name", fileName, "bno", "" + bno, "ord", "" + index.getAndIncrement());
        }).collect(Collectors.toList());

        log.info("=====================================================================");
        log.info("=====================================================================");
        log.info(list);

        //파일 등록 실행
        fileUploadMapper.registerImage(list);
    }

    }
}
