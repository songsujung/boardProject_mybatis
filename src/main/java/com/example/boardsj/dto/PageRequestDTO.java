package com.example.boardsj.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// 페이지 번호와 페이지 사이즈를 구하는 DTO

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PageRequestDTO {

    // @Builder.Default : 특정 필드를 특정 값으로 초기화
    @Builder.Default
    private int page = 1; // 페이지 번호
    @Builder.Default
    private int size = 10; // 페이지 사이즈
    private String type;      // 검색type
    private String keyword;   // 검색어
    private String link;      // 검색조건, 페이지, 사이즈 통합
    private boolean replyLast; //댓글 페이징 마지막 페이지 유무


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

    // limit에 들어갈 skip 계산
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

    // 검색기능
    // type 배열로 반환 처리
    public String[] getTypes() {

        // 만약 type이 null이거나 비어있다면 null을 반환
        if (this.type == null || this.type.isEmpty()) {
            return null;
        }

        // type 문자열을 빈 문자열("")을 기준으로 나누어 배열로 반환
        return this.type.split("");
    }

    // link
    public String getLink() {

        if (link == null) {

            // 새로운 문자열 생성하기 위해 strBuiler 객체 생성
            StringBuilder strBuilder = new StringBuilder();

            // 페이지,사이즈 append -> 페이지,사이즈를 문자열 형태로 strBuilder에 추가
            strBuilder.append("page=" + this.page);
            strBuilder.append("&size=" + this.size);

            // 검색타입
            if (type != null && type.length() > 0) {
                
                // 검색타입을 strBuilder에 추가
                strBuilder.append("&type=" + this.type);
            }

            // 검색어
            if (keyword != null) {
                try {

                    // 키워드를 strBuilder에 추가. 
                    // 검색어는 URL 인코딩을 해야하기에 URLEncoder.encode()를 사용하여 인코딩된 문자열로 변환
                    strBuilder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));

                    // 예외 처리
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            // 모든조건 추가한 후 strBuilder의 내용을 문자열로 변환 후 link에 저장
            link = strBuilder.toString();
        }

        // link 반환
        return link;

    }
}