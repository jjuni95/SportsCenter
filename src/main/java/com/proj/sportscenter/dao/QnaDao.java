package com.proj.sportscenter.dao;

import java.util.List;

import com.proj.sportscenter.vo.QnaVo;

public interface QnaDao {

	int insertQna(QnaVo Qna);

	public List<QnaVo> selectUserByQnaWriter(String qnaWriter);

	public List<QnaVo> list() throws Exception;

	QnaVo selectQnaByNo(long no);

	public QnaVo qnaDelete(long qnaNo);
	

}
