package com.proj.sportscenter.service;

import javax.servlet.http.HttpSession;

import com.proj.sportscenter.vo.UserVo;

public interface UserService {

	UserVo signup(UserVo user);

	UserVo getUserInfo(String userId);

	UserVo login(String userId, String password, HttpSession session);

}
