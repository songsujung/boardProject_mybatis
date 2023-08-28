package com.example.boardsj.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    
}
