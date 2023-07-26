package com.example.boardsj.dto;

// 페이지 번호와 페이지 사이즈를 구하는 DTO

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PageRequestDTO {

    // @Builder.Default : 특정 필드를 특정 값으로 초기화
    @Builder.Default
    private int page = 1; // 페이지 번호

    @Builder.Default
    private int size = 10; // 페이지 사이즈

    // 페이지 번호
    // page가 0보다 작으면 1로 설정, 아니면 그 페이지값으로 설정(페이지번호가 마이너스로 뜨지 않게 하기 위해)
    public void setPage(int page) {

        if (page < 0) {
            this.page = 1;
        }else {
            this.page = page;
        } // if end

    }

    // 페이지 사이즈
    // size가 0보다 작거나, 100보다 크면 10으로 설정, 아니면 그 사이즈값으로 설정(페이지에 너무 많은 양의 데이터가 뜨지않게 제한)
    public void setSize(int size) {

        if (size < 0 || size > 100) {
            this.size = 10;
        }else {
            this.size = size;
        } // if end

    }

    // limit에 들어 갈 skip 계산
    // 예시) page가 3(페이지)이고, size가 10이면 20까지 스킵
    public int getSkip() {

        return (this.page - 1) * this.size;
    }

    // next 버튼을 위한 count 구하기
    // 예) page=9, size=10이면, (9/10.0 = 0.9, 올림(ceil)처리해서 = 1) * (10 * 10 =100) = 100
    // result = 100이고, + 1 => 101개
    public int getCountEnd() {

        int result = (int)Math.ceil(this.page / 10.0) *(this.size * 10);

        return result + 1;
    }
}
