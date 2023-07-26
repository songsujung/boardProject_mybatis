//paging 함수 생성
function makePages(page, size, total) {


    let pagingResult = "";

    const startNum = (Math.ceil(page / 10) * 10) - 9;

    startNum !== 1 ? pagingResult += `<a href="${startNum - 1}" class="btn btn-primary"><</a>` : "";

    let temp = startNum;

    while(true) {
        if(temp * 10 > total) {
            break;
        }

        temp === page ? pagingResult += `<a href="${temp}" class="btn btn-primary active">${temp}</a>` : pagingResult += `<a href="${temp}" class="btn btn-primary">${temp}</a>`

        temp++;
    }

    total % (size * 10) === 1 ? pagingResult += `<a href="${temp}" class="btn btn-primary">></a>` : "";


    return pagingResult;


}