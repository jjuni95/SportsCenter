package com.proj.sportscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.sportscenter.dao.QnaDao;
import com.proj.sportscenter.service.QnaService;
import com.proj.sportscenter.vo.QnaVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDao qnadao;

	@Override
	public void enroll(QnaVo Qna) {
		qnadao.enroll(Qna);
	}
	}
	
	

