package com.itshixun.service.impl;

import java.util.List;

import com.itshixun.dao.UserDao;
import com.itshixun.entity.User;
import com.itshixun.service.UserService;

public class UserServiceImpl implements UserService {

	public UserDao userDao = null;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User userLogin(User user) {
		return userDao.userLogin(user);
	}

	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	public List<User> selectUser() {
		return userDao.selectUser();
	}

	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	public User selectByUserId(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectByUserId(userId);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	public int updateUserPhoto(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserPhoto(user);
	}
	public User forgetPwd(User user) {
		// TODO Auto-generated method stub
		return userDao.forgetPwd(user);
	}


	public int updatePwd(User user) {
		// TODO Auto-generated method stub
		return userDao.updatePwd(user);
	}

}