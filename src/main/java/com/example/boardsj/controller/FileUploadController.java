package com.example.boardsj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/files/")
@RequiredArgsConstructor
public class FileUploadController {
    
    //custom 예외처리
    public static class DataNotFoundException extends RuntimeException{
        public DataNotFoundException(String msg){
        super(msg);
        }
    }
}
