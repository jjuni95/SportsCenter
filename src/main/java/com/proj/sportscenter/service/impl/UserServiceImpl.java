package com.proj.sportscenter.service.impl;

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
		
		String userId = user.getUserId();
		UserVo resultUser = userDao.selectUserByUserId(userId);
		
		return resultUser;
	}
	
	@Transactional
	@Override
	public boolean login(String userId, String password) {
		UserVo user = userDao.selectUserByUserId(userId);
		
		if(user.getUserId() == null) {
			System.out.println("해당 아이디의 유저가 존재하지 않습니다.");
			return false;
		}
		if(!passwordEncoder.matches(password, user.getPassword())) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return false;
		}
		return true;
		
	}
	
	
}
