package com.proj.sportscenter.dao;

import com.proj.sportscenter.vo.UserVo;

public interface UserDao {

	int insertUser(UserVo user);

	UserVo selectUserByUserId(String userId);


	
}
