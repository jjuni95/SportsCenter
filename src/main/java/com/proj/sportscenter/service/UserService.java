package com.proj.sportscenter.service;

import com.proj.sportscenter.vo.UserVo;

public interface UserService {

	UserVo signup(UserVo user);

	boolean login(String userId, String password);
}

	
