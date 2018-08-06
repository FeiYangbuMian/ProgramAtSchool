package com.itshixun.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.dao.DuplicateKeyException;

import com.itshixun.entity.Goods;
import com.itshixun.entity.User;
import com.itshixun.service.GoodsService;
import com.itshixun.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserManagerAction extends ActionSupport implements SessionAware {
	public User user;
	public UserService userService;
	public String msg;
	public GoodsService goodsService;
	public List<Goods> list;
	public List<User> userList;
	public Map<String, Object> session;
	public String identity;
	public String codecheck;
	private File myfile;
	private String myfileFileName;// 第一个文件的变量名（myfile）+FileName
	// 不然获取不了
	private String savePath;

	// 判断登录
	public String userLogin() {
		if ("s".equals(codecheck)) {
			msg = "验证码错误";
			return "clientlogin";
		} else {
			User loginUser = userService.userLogin(user);
			if (loginUser != null) {
				if (identity.equals(loginUser.getUserStatus())) {
					if (identity.equals("0")) {
						session.put("loginUser", loginUser);
						return "clientshowPhoto";
					} else {
						session.put("loginUser", loginUser);
						return "home";
					}
				} else {
					msg = "身份错误";
					return "clientlogin";
				}
			} else {
				msg = "用户名或密码错误";
				return "clientlogin";
			}
		}
	}

	// 注册用户
	public String insertUser() {
		try {
			msg = null;
			int count = userService.insertUser(user);
			if (count > 0) {
				msg = "注册成功，请登录！";
				return "clientlogin";
			} else {
				msg = "注册失败，请重新注册！";
				return "clientregister";
			}
		} catch (DuplicateKeyException e) {
			msg = "用户名已存在，请重新输入！";
			return "clientregister";
		}
	}

	// 忘记密码时的判断
	public String forgetPwd() {
		User loginUser = userService.forgetPwd(user);
		if (loginUser != null) {
			session.put("loginUser", loginUser);
			return "clientupdatePwd";
		} else {
			msg = "用户名或电子邮箱错误";
			return "clientforgetPwd";
		}
	}

	// 修改密码
	public String updatePwd() {
		msg = null;
		int count = userService.updatePwd(user);
		User loginUser = userService.selectByUserId(user.getUserId());
		if (count > 0) {
			session.put("loginUser", loginUser);
			msg = "修改成功，请重新登录！";
		} else {
			msg = "修改密码失败！";
		}
		return "clientlogin";
	}

	// 用户列表展示
	public String selectUser() {
		msg = null;
		userList = userService.selectUser();
		if (userList != null) {
			return "show";
		} else {
			return "home";
		}
	}

	// 删除用户
	public String deleteUser() {
		msg = null;
		int count = userService.deleteUser(user.getUserId());
		if (count > 0) {
			userList = userService.selectUser();
			msg = "删除成功！";
		} else {
			msg = "删除失败！";
		}
		return "show";
	}

	public String selectByUserId() {
		msg = null;
		user = userService.selectByUserId(user.getUserId());
		if (user == null) {
			msg = "该用户不存在！";
			userList = userService.selectUser();
		} else {
			userList = null;
		}
		return "clientshow";
	}

	public String updateUser() {
		msg = null;
		int count = userService.updateUser(user);
		User loginUser = userService.selectByUserId(user.getUserId());
		if (count > 0) {
			list = goodsService.selectGoodsByUserId(user.getUserId());
			session.put("loginUser", loginUser);
		} else {
			msg = "修改用户失败！";
		}
		return "clientpersonalInfo";
	}

	public String updateUserPhoto() {
		System.out.println(user.getUserId());
		System.out.println(user.getUserPhoto());
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(this.getSavePath() + "\\" + this.getMyfileFileName());
			fis = new FileInputStream(this.getMyfile());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			user.setUserPhoto(myfileFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		msg = null;
		int count = userService.updateUserPhoto(user);
		User loginUser = userService.selectByUserId(user.getUserId());
		if (count > 0) {
			list = goodsService.selectGoodsByUserId(user.getUserId());
			session.put("loginUser", loginUser);
		} else {
			msg = "修改用户失败！";
		}
		return "clientpersonalInfo";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getCodecheck() {
		return codecheck;
	}

	public void setCodecheck(String codecheck) {
		this.codecheck = codecheck;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

}
