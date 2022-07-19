package com.proj.sportscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.sportscenter.dao.QnaDao;
import com.proj.sportscenter.service.QnaService;
import com.proj.sportscenter.vo.QnaVo;
import com.proj.sportscenter.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDao qnadao;


	@Transactional
	@Override
	public QnaVo insertQna(QnaVo qna) {

		int result = qnadao.insertQna(qna);
		if (result == 0)
			throw new RuntimeException("디비 insert 실패");
//
////		유저 정보 조회
//		String qnaWriter = qna.getQnaWriter();
//		QnaVo resultQna = qnadao.selectUserByQnaWriter(qnaWriter);
		

//		질문으로 정보 조회 (test0
		String qnaQuestion = qna.getQnaQuestion();
		QnaVo resultQna = qnadao.selectUserByQnaQuestion(qnaQuestion);

		return resultQna;
	}

}
