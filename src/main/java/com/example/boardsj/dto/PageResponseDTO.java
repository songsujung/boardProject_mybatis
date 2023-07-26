package com.example.boardsj.dto;

// page 반환해주는 DTO

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PageResponseDTO<E> {

    private List<E> list; // 리스트를 출력해 줄 List

    private int total; // PageRequestDTO에서 getCountEnd를 담을 변수

    @Builder(builderMethodName = "withAll") // Builder를 withAll이라는 이름으로 지정해서 사용
    public PageResponseDTO(List<E> list, int total) {
        this.list = list;
        this.total = total;
    }
}
