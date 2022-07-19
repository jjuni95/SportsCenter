package com.proj.sportscenter.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.sportscenter.dao.QnaDao;
import com.proj.sportscenter.vo.QnaVo;

@Repository
public class QnaDaoImpl implements QnaDao {

	
	@Autowired
	private SqlSessionTemplate ssl;

	@Override
	public int insertQna(QnaVo qna) {
		return ssl.insert("qna.insertQna", qna);		
	}
	
	@Override
	public List<QnaVo> selectUserByQnaWriter(String qnaWriter) {
		return ssl.selectList("qna.selectUserByQnaWriter", qnaWriter);
	}
	
	@Override
	public List<QnaVo> list() throws Exception {		
		return ssl.selectList("qna.listQna");
	}


}
