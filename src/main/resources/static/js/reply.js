
// 댓글 비동기통신 처리

const realPath = "http://localhost:8080"

// 목록
const getList = async(replyLast = false, page = 1) => {
    const res = await axios.get(`${realPath}/api/replies/${bno}/list?page=${page}&replyLast=${replyLast}`)
    return res.data
}

// 등록
const postRegister = async(data) => {
    const res = await axios.post(`${realPath}/api/replies/${bno}/register`, data)
    return res.data
}
  
 // 조회
const getReadOne = async(rno) => {
    const res = await axios.get(`${realPath}/api/replies/read/${rno}`)
    return res.data
}
  
// 삭제
const deleteReply = async(rno) => {
    const res = await axios.delete(`${realPath}/api/replies/delete/${rno}`)
    return res.data
}
  
// 수정
const putReply = async(reply) => {
    const res = await axios.put(`${realPath}/api/replies/modify/${reply.rno}`, reply)
    return res.data
}

//list 함수로 선언
const getListDefault = (replyLast, page) => {
  getList( replyLast, page).then(arr => {
    let replyStr = ""
    let replyPagingStr = ""
    //console.log(arr)
    for(let i = 0; i < arr.list.length; i++){
      const {reply, replyer, replyDate, step, gno, rno} = arr.list[i]
      replyStr += `
        <div class="d-flex align-items-center py-3 border-top${step === 0 ? "" : " ps-3"}">
          <div class="w-100">
            <div class="d-flex w-100 justify-content-between">
              <h6 class="mb-0">${reply}</h6>
            </div>
            <span>${replyer}</span>
            <small class="mx-3">${replyDate}</small>
            <button class="btn btn-outline-secondary" data-reply="reply" data-gno="${gno}">Reply</button>
            <button class="btn btn-outline-primary" data-reply="modify" data-rno="${rno}">Modify</button>
          </div>
        </div>
      `
    }

    const {page, size, startNum, endNum, prevBtn, nextBtn, replyLast, total} = arr
    console.log(arr)

    prevBtn === true ? replyPagingStr += `<li><button data-page="${startNum - 1} class="btn btn-primary"><</button></li>` : ""

    for(let i = startNum; i <= endNum; i++){
      replyPagingStr += `
        <li${page === i ? " class='active'" : ''}>
          <button data-page="${i}" class="btn btn-primary">${i}</button>
        </li>
      `
    }

    nextBtn === true ? replyPagingStr += `<li><button data-page="${endNum + 1} class="btn btn-primary">></button></li>` : ""

    //console.log(replyLast = Math.ceil((page * size) / total) === 1 ? true : false)
    //console.log(replyStr)
    //console.log(replyPagingStr)
    replyWrap.innerHTML = replyStr
    replyPaging.innerHTML = replyPagingStr
  })
}