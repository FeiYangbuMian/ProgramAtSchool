package com.itshixun.service;

import java.util.List;

import com.itshixun.entity.User;

public interface UserService {

	public abstract User userLogin(User user);

	public abstract int insertUser(User user);

	public List<User> selectUser();

	public abstract int deleteUser(int id);

	public User selectByUserId(int userId);

	public abstract int updateUser(User user);

	public abstract int updateUserPhoto(User user);
	
	public abstract User forgetPwd(User user);
	
	public abstract int updatePwd(User user);

}
