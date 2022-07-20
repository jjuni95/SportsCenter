package com.proj.sportscenter.service;

import java.util.List;

import com.proj.sportscenter.vo.QnaVo;

public interface QnaService {

	public List<QnaVo> insertQna(QnaVo Qna);
	
	public List<QnaVo> list() throws Exception;

	QnaVo getQnaByNo(long no);

	public void qnaDelete(long qnaNo);
	
	//게시판 목록(페이징 적용)
//	public List<QnaVo> pagingQna(Criteria cri);

}
