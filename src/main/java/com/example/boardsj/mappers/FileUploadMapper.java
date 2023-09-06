package com.example.boardsj.mappers;

import java.util.List;
import java.util.Map;

public interface FileUploadMapper {

    // 이미지 및 파일 등록
    int registerImage(List<Map<String, String>> imageList);

    int deleteImage(Long bno);
    
}
