package com.proj.sportscenter.dao.impl;

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
	public int enroll(QnaVo qna) {
		return 0;
	}
	

}
