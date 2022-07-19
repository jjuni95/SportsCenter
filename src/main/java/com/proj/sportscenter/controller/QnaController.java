package com.proj.sportscenter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proj.sportscenter.service.QnaService;
import com.proj.sportscenter.vo.QnaVo;
import com.proj.sportscenter.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;

	// 게시판 목록 조회
	@GetMapping(value = "/qnalist")
	public String viewQnaList(Model model) throws Exception {
		model.addAttribute("list", qnaService.list());
		return "qnalist";
	}
	
	@GetMapping(value = "/postqna")
	public String postQna() throws Exception {
		return "postqna"; // qna쓰는곳
	}

	@GetMapping(value = "/qna/{no}")
	public ModelAndView writeQna(@PathVariable(value = "no") long no, ModelAndView mav) throws Exception {
		
		log.debug("[no]=[{}]", no);
		
		QnaVo qnaVo = qnaService.getQnaByNo(no);
		log.debug("[qnaVo]=[{}]", qnaVo);
		
		mav.setViewName("view-qna");
		mav.addObject("qna", qnaVo);
		
		return mav;
	}
	
	
	@PostMapping(value = "/postqna")
	public String insertQna(HttpSession session, QnaVo qna) throws Exception {
//		파라미터가 올바른 값인지 체크 해준다.
//		if(qna.getQnaTitle() == null || qna.getQnaTitle().length() < 1)
//			throw new RuntimeException("타이틀이 널값 입니다.");
//
////		파라미터가 올바른 값인지 체크 해준다.
//		if(qna.getQnaQuestion() == null || qna.getQnaQuestion().length() < 1)
//			throw new RuntimeException("내용이 널값 입니다.");

		UserVo user = (UserVo) session.getAttribute("user");
		qna.setQnaWriter(user.getUserId());

		log.debug("[qna]=[{}]", qna);

		
//		서비스 로직 
		List<QnaVo> resultQna = qnaService.insertQna(qna);
		log.debug("[resultQna]=[{}]", resultQna);

		return "redirect:/qnalist";
	}

}
