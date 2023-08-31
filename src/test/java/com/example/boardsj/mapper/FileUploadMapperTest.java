package com.example.boardsj.mapper;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.boardsj.dto.BoardDTO;
import com.example.boardsj.mappers.BoardMapper;
import com.example.boardsj.mappers.FileUploadMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class FileUploadMapperTest {

    // 의존성 주입
    @Autowired(required = false)
    private FileUploadMapper fileUploadMapper;

    @Autowired(required = false)
    private BoardMapper boardMapper;

    @Test
    @Transactional
    //@Commit
    public void testFileUpload(){
    // 등록
    BoardDTO boardDTO = BoardDTO.builder()
      .title("File Mapper Test Title1")
      .content("File Mapper Test Content1")
      .writer("File Mapper test writer1")
      .fileNames(List.of(UUID.randomUUID() + "_f1.jpg", UUID.randomUUID() + "_f2.jpg"))
      .build();

    // 파일이름 List로 가져오기
    List<String> fileNames = boardDTO.getFileNames();

    // 게시판 등록
    int count = boardMapper.regist(boardDTO);
    log.info("insert product count: " + count);

    // 게시판 등록 성공과 파일이 등록되었다면 실행
    if(count > 0 && boardDTO.getFileNames() != null && !boardDTO.getFileNames().isEmpty()){
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

      // 파일 등록 실행
      fileUploadMapper.registerImage(list);
    }
  }
    
}
