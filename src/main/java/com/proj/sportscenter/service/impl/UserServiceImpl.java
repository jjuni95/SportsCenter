package com.proj.sportscenter.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.sportscenter.dao.UserDao;
import com.proj.sportscenter.service.UserService;
import com.proj.sportscenter.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public UserVo signup(UserVo user) {
//		비밀번호 암호화
		String oldPassword = user.getPassword();
		log.debug("[oldPassword]=[{}]", oldPassword);
		
		String newPassword = passwordEncoder.encode(oldPassword);
		user.setPassword(newPassword);
		log.debug("[newPassword]=[{}]", newPassword);
		
		int result = userDao.insertUser(user);
		if(result == 0) 
			throw new RuntimeException("디비 insert 실패");
		
//		유저 정보 조회
		String userId = user.getUserId();
		UserVo resultUser = userDao.selectUserByUserId(userId);
		
		return resultUser;
	}

	@Override
	public UserVo getUserInfo(String userId) {
		return userDao.selectUserByUserId(userId);
	}

	/**
	 * 로그인
	 */
	@Override
	public UserVo login(String userId, String password, HttpSession session) {
		
//		DB에서 해당 아이디를 가진 유저 조회
		UserVo user = userDao.selectUserByUserId(userId);
		
		if(user == null)
			throw new RuntimeException("아이디가 X");
		
		log.debug("[password]=[{}]", password);
		
//		password = 로그인을 위해 입력한 패스워드
//		user.getPassword() = DB에 암호화 된 패스워드
		if (!passwordEncoder.matches(password, user.getPassword()))
			throw new RuntimeException("비밀번호 X");
		
//		세션에 유저 정보 등록
		log.debug("[user]=[{}]", user);
		session.setAttribute("user", user);
		
		return null;
	}
	
	
}
