package com.proj.sportscenter.dao;

import java.util.List;

import com.proj.sportscenter.vo.QnaVo;

public interface QnaDao {
	
	int insertQna(QnaVo Qna);
	
	QnaVo selectUserByQnaWriter(String qnaWriter);
//	QnaVo selectUserByQnaQuestion(String qnaQuestion);
	
	
	//게시물 목록 조회
	public List<QnaVo> list() throws Exception;
	

}
