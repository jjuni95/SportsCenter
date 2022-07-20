package com.proj.sportscenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proj.sportscenter.service.UserService;
import com.proj.sportscenter.vo.NoticeVo;
import com.proj.sportscenter.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/main")
	public String viewMainPage() throws Exception {
		return "main";
	}

	// intro로 이동
	@GetMapping(value = "/intro")
	public String viewIntroPage() throws Exception {
		return "intro";
	}

	/**
	 * 로그인 페이지 이동
	 */
	@GetMapping(value = "/login")
	public String viewLoginPage() throws Exception {
		return "login";
	}

	// 프로그램 시간표로 이동
	@GetMapping(value = "/program_sche")
	public String viewSche() throws Exception {
		return "program_sche";
	}

	// 회원가입 페이지 이동
	@GetMapping(value = "/signup")
	public String viewRegistPage() throws Exception {
		return "signup";
	}

	// 로그인 요청
	@PostMapping(value = "/login")
	public String login(HttpSession session, @RequestParam(value = "userId") String userId,
			@RequestParam(value = "password") String password) throws Exception {

		log.debug("[userId]=[{}]", userId);
		log.debug("[userPassword]=[{}]", password);

//		유저아이디와 비밀번호를 들고 유저 조회
		UserVo user = userService.login(userId, password, session);

		return "redirect:/qnalist";
	}

	// 로그아웃
	@PostMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/main";
	}

	//회원 가입 요청
	@PostMapping(value = "/signup")
	public String signup(UserVo user) throws Exception {
//		파라미터가 올바른 값인지 체크 해준다.
		if (user.getUserId() == null || user.getUserId().length() < 1)
			throw new RuntimeException("아이디가 널값 입니다.");

		log.debug("[user]=[{}]", user);

//		서비스 로직 
		UserVo resultUser = userService.signup(user);
		log.debug("[resultUser]=[{}]", resultUser);

		return "login";
	}

}
