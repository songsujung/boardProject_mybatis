package com.example.boardsj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BoardDTO {

    private Long tno;

    private String title;

    private String content;

    private String writer;

    private Date regDate;

    private Date updateDate;
    
}
