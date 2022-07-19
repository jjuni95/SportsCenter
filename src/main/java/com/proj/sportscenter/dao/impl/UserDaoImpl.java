package com.proj.sportscenter.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.sportscenter.dao.UserDao;
import com.proj.sportscenter.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSessionTemplate ssl;
	
	/**
	 * 유저정보 추가
	 */
	@Override
	public int insertUser(UserVo user) {
//		"user.insertUser" = "${namespace}.${id}"
		return ssl.insert("user.insertUser", user);
	}

	/**
	 * 아이디를 이용해 유저 정보 조회
	 */
	@Override
	public UserVo selectUserByUserId(String userId) {
		return ssl.selectOne("user.selectUserByUserId", userId);
	}

}
