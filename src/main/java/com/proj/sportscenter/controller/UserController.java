package com.proj.sportscenter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.proj.sportscenter.service.UserService;
import com.proj.sportscenter.vo.UserVo;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/login")
	public String viewLoginPage() throws Exception {
		return "login";
	}
	
	@GetMapping(value = "/signup")
	public String viewRegistPage() throws Exception{
		return "signup";
	}
	
	@PostMapping(value = "/signup")
	public String signup(UserVo user) throws Exception {
//		파라미터가 올바른 값인지 체크 해준다.
		if(user.getUserId() == null || user.getUserId().length() < 1)
			throw new RuntimeException("아이디가 널값 입니다.");

		log.debug("[user]=[{}]", user);
		
//		서비스 로직 
		UserVo resultUser = userService.signup(user);
		log.debug("[resultUser]=[{}]", resultUser);
		
		return "signup-done";
	}
	
	@PostMapping(value = "/login")
	public String login(String userId, String password) throws Exception{	
		
		boolean loginUser = userService.login(userId, password);
		if(loginUser) {
			return "login-done";
		}
		return "login";
	}
}
