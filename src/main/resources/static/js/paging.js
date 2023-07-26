// paging 함수 생성

//  page, size, total이라는 매개변수를 받는 makePages함수 정의
function makePages(page, size, total) {

    // 페이징처리 결과값을 받을 변수를 빈 문자열로 선언
    let pagingResult = ""

    // 페이징 첫번째 번호 계산
    // 예) 현재페이지가 17일때, 17 / 10 = 1.7(올림해서) => 2이고, 2 * 10 = 20, 20-9 = 11
    // => 페이지 17의 시작페이지는 11
    const startNum = (Math.ceil(page / 10) * 10) - 9;

    // 시작번호가 1번이면 이전버튼 노출 X
    startNum != 1 ? pagingResult += `<a href="${startNum - 1}" class="btn btn-primary"><</a>` : "";

    // 페이징 번호 변수
    let temp = startNum

    // 페이징 버튼 동적 생성 : while(true) 무한반복문
    while (true) {

        // 페이징번호 * size 이 total보다 크면 break
        if (temp * size > total) {
            // total % 현재 페이지가 속한 페이지 블록의 마지막 페이지 번호 !== 1일때,
            if(total % (Math.ceil(page / 10) * (10 * size)) !== 1){
                temp == page ? pagingResult += `<a href="${temp}" class="btn btn-primary active">${temp}</a>` : pagingResult += `<a href="${temp}" class="btn btn-primary">${temp}</a>`
            }
            break
        } // if end

        // page와 temp가 같으면 active 처리
        temp === page ? pagingResult += `<a href="${temp}" class="btn btn-primary active">${temp}</a>` : pagingResult += `<a href="${temp}" class="btn btn-primary">${temp}</a>`

        temp++ // 증가
    }

    // total % 현재 페이지가 속한 페이지 블록의 마지막 페이지 번호 === 1이면 다음페이지로 이동하는 링크 노출
    total % (Math.ceil(page / 10) * (10 * size)) === 1 ? pagingResult += `<a href="${temp}" class="btn btn-primary">></a>` : ""

    return pagingResult

}