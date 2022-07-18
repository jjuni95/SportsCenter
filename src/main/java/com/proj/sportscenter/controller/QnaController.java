package com.proj.sportscenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.proj.sportscenter.service.UserService;
import com.proj.sportscenter.vo.NoticeVo;
import com.proj.sportscenter.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QnaController {

	@GetMapping(value = "/qna")
	public String viewQnaList() throws Exception {
		return "qna";
	}

	@GetMapping(value = "/postqna")
	public String postQna() throws Exception {
		return "postqna";
	}

}
