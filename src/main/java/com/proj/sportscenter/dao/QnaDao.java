package com.proj.sportscenter.dao;

import com.proj.sportscenter.vo.QnaVo;

public interface QnaDao {
	
	int insertQna(QnaVo Qna);
	
//	QnaVo selectUserByQnaWriter(String qnaWriter);
	QnaVo selectUserByQnaQuestion(String qnaQuestion);

}
