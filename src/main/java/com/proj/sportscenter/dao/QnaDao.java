package com.proj.sportscenter.dao;

import java.util.List;

import com.proj.sportscenter.vo.QnaVo;

public interface QnaDao {
	
	int insertQna(QnaVo Qna);
	
<<<<<<< HEAD
	public List<QnaVo> selectUserByQnaWriter(String qnaWriter);
	
	public List<QnaVo> list() throws Exception;
=======
	QnaVo selectUserByQnaWriter(String qnaWriter);
//	QnaVo selectUserByQnaQuestion(String qnaQuestion);
	
	
	//게시물 목록 조회
	public List<QnaVo> list() throws Exception;
	
>>>>>>> 02f07d948ce45c7d3965de4c7e3fc71a4c3d9ae8

}
