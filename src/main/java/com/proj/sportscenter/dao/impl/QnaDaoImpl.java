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

	//qna-mapper실행 : qna.insertQna을 실행시키는데
	// 입력한거에서 QnaVo를 가져온다  
	@Override
	public int insertQna(QnaVo qna) {
<<<<<<< HEAD
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


=======
		return ssl.insert("qna.insertQna", qna);
	}
	
	/**
	 * 아이디를 이용해 유저 정보 조회
	 */
	@Override
	public QnaVo selectUserByQnaWriter(String qnaWriter) {
		return ssl.selectOne("qna.selectUserByQnaWriter", qnaWriter);
	}
	
	//게시물 목록 조회
	@Override
	public List<QnaVo> list() throws Exception{
		return ssl.selectList("qna.listQna");
	}
>>>>>>> 02f07d948ce45c7d3965de4c7e3fc71a4c3d9ae8
}
