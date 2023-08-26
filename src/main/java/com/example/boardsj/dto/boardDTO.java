package com.example.boardsj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BoardDTO {

    private Long bno;

    private String title;

    private String content;

    private String writer;

    private Date regDate;

    private Date updateDate;

    private List<String> fileNames; // 파일업로드(파일명)
    
}
