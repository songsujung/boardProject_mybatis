package com.example.boardsj.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.boardsj.dto.PageRequestDTO;
import com.example.boardsj.dto.ReplyDTO;

public interface ReplyMapper {

    // list
    List<ReplyDTO> getList(
        @Param("bno") Integer bno, @Param("pr") PageRequestDTO pageRequestDTO
    );
    
}
