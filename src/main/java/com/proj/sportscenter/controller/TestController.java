package com.proj.sportscenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proj.sportscenter.service.UserService;
import com.proj.sportscenter.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/test")
	public ModelAndView testView(ModelAndView mav) throws Exception {
		
		String userId = "qwqw04141";
		
		UserVo userVo = userService.getUserInfo(userId);
		log.debug("[userVo]=[{}]", userVo);
		
		mav.addObject("user", userVo);
		mav.setViewName("test");
		
		return mav;
	}
	
}
