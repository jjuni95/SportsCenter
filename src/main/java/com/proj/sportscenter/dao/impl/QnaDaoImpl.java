package com.proj.sportscenter.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.sportscenter.dao.QnaDao;
import com.proj.sportscenter.vo.QnaVo;
import com.proj.sportscenter.vo.UserVo;

@Repository
public class QnaDaoImpl implements QnaDao {

	@Autowired
	private SqlSessionTemplate ssl;

	//qna-mapper실행 : qna.insertQna을 실행시키는데
	// 입력한거에서 QnaVo를 가져온다  
	@Override
	public int insertQna(QnaVo qna) {
		return ssl.insert("qna.insertQna", qna);
	}
	
	/**
	 * 아이디를 이용해 유저 정보 조회
	 */
	@Override
	public QnaVo selectUserByQnaQuestion(String qnaQuestion) {
		return ssl.selectOne("qna.selectUserByQnaQuestion", qnaQuestion);
	}
}
