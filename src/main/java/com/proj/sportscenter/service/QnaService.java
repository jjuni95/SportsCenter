package com.proj.sportscenter.service;

import java.util.List;

import com.proj.sportscenter.vo.QnaVo;

public interface QnaService {

	public QnaVo insertQna(QnaVo Qna);
	
	public List<QnaVo> list() throws Exception;
}
