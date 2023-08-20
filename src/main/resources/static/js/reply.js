
// 댓글 비동기통신 처리

// 목록
const getList = async(replyLast = false, page = 1) => {
    const res = await axios.get(`${realPath}/api/replies/${bno}/list?page=${page}&replyLast=${replyLast}`)
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