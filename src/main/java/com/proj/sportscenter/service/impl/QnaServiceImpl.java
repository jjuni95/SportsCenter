package com.proj.sportscenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.sportscenter.dao.QnaDao;
import com.proj.sportscenter.service.QnaService;
import com.proj.sportscenter.vo.QnaVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDao qnadao;

	@Transactional
	@Override

	public List<QnaVo> insertQna(QnaVo qna) {

		int result = qnadao.insertQna(qna);
		if (result == 0)
			throw new RuntimeException("디비 insert 실패");

		// 유저 정보 조회
		String qnaQuestion = qna.getQnaWriter();
		List<QnaVo> resultQna = qnadao.selectUserByQnaWriter(qnaQuestion);

		return resultQna;
	}

	@Override
	public List<QnaVo> list() throws Exception {
		return qnadao.list();
	}

}
