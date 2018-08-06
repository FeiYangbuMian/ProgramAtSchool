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

import com.itshixun.entity.Goods;
import com.itshixun.entity.User;
import com.itshixun.service.GoodsService;
import com.itshixun.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsManagerAction extends ActionSupport implements SessionAware {
	public Goods goods;
	public User user;
	public Map<String, Object> session;
	public GoodsService goodsService;
	public UserService userService;
	public List<Goods> list;
	public String msg;
	// 照片上传与下载
	private File myfile;// 这三个狗东西是固定的,浪费了老子一下午，还有晚自习这40分钟
	private String myfileFileName;// 第一个文件的变量名（myfile）+FileName
	// 不然获取不了
	private String savePath;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public String insertGoods() {
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
			goods.setGoodPhoto(myfileFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int count = goodsService.insertGoods(goods);
		if (count > 0) {
			list = goodsService.selectGoodsByUserId(goods.getUserId());
			return "clientpersonalInfo";
		} else {
			return "clienterror";
		}
	}

	public String selectGoodsByUserId() {
		msg = null;
		list = goodsService.selectGoodsByUserId(goods.getUserId());
		return "clientpersonalInfo";
	}

	public String showGoodsAllClient() {
		msg = null;
		list = goodsService.showGoodsAllClient();
		goods = null;
		if (list != null) {
			return "clientshowGoodsAllClient";
		}
		return "clientsuccess";

	}

	public String showGoodsAll() {
		msg = null;
		list = goodsService.showGoodsAll();
		goods = null;
		if (list != null) {
			return "showGoodsAll";
		}
		return "success";

	}

	public String showGoodsStation() {
		list = goodsService.showGoodsStation();
		return "showGoodsStation";

	}

	public String showGoodsDigital() {
		list = goodsService.showGoodsDigital();
		return "clientshowGoodsDigital";

	}

	public String showGoodsFitting() {
		list = goodsService.showGoodsFitting();
		return "clientshowGoodsFitting";

	}

	public String showGoodsSkincare() {
		list = goodsService.showGoodsSkincare();
		return "clientshowGoodsSkincare";

	}

	public String showGoodsMakeup() {
		list = goodsService.showGoodsMakeup();
		return "clientshowGoodsMakeup";

	}

	public String showGoodsFour() {
		list = goodsService.showGoodsFour();
		return "clientshowGoodsFour";

	}

	public String showGoodsCream() {
		list = goodsService.showGoodsCream();
		return "clientshowGoodsCream";

	}

	public String showGoodsLip() {
		list = goodsService.showGoodsLip();
		return "clientshowGoodsLip";

	}

	public String showGoodsPad() {
		list = goodsService.showGoodsPad();
		return "clientshowGoodsPad";

	}

	public String deleteGoodsById() {
		msg = null;
		int count = goodsService.deleteGoodsById(goods.getGoodId());
		if (count > 0) {
			list = goodsService.showGoodsAllClient();
			msg = "删除成功！";
		} else {
			msg = "删除失败！";
		}
		goods = null;
		return "clientshowGoodsAllClient";
	}

	// 修改商品状态进回收站
	public String updateGoodState() {
		int count = goodsService.updateGoodState(goods.getGoodId());
		if (count > 0) {
			list = goodsService.showGoodsAll();
			goods = null;
		} else {
			System.out.println("删除失败！");
		}
		return "showGoodsAll";
	}

	// 修改商品状态移除商品回收站
	public String updateGoodStation() {
		int count = goodsService.updateGoodStation(goods.getGoodId());
		if (count > 0) {
			list = goodsService.showGoodsStation();
			goods = null;
		} else {
			System.out.println("删除失败！");
		}
		return "showGoodsStation";
	}

	public String selectGoodsById() {
		msg = null;
		goods = goodsService.selectGoodsById(goods.getGoodId());
		msg = "该用户不存在！";
		list = goodsService.showGoodsAll();
		goods = null;
		return "showGoodsAll";
	}

	public String selectGoodsByIdClient() {
		msg = null;
		goods = goodsService.selectGoodsByIdClient(goods.getGoodId());
		if (goods == null) {
			msg = "该商品不存在！";
			list = goodsService.showGoodsAllClient();
			return "personalInfo";
		} else {
			return "updateGoods";
		}
	}

	public String findGoodsById() {
		msg = null;
		goods = goodsService.findGoodsById(goods.getGoodId());
		return "clientupdateGoods";

	}

	public String updateGoodsById() {
		goodsService.updateGoodsById(goods);
		list = goodsService.selectGoodsByUserId(goods.getUserId());
		goods = null;
		return "clientpersonalInfo";

	}

	public String updateGoodsPhoto() {
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
			goods.setGoodPhoto(myfileFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int count = goodsService.updateGoodsPhoto(goods);
		if (count > 0) {
			list = goodsService.selectGoodsByUserId(user.getUserId());
		} else {
			msg = "修改用户失败！";
		}
		return "clientpersonalInfo";
	}

	public String selectOneGoods() {
		msg = null;
		goods = goodsService.selectGoodsById(goods.getGoodId());
		if (goods == null) {
			msg = "该用户不存在！";
			list = goodsService.showGoodsAll();
		} else {
			list = null;
		}

		return "showGoodsAll";
	}

	public String selectGoodsDetail() {
		msg = null;
		goods = goodsService.selectGoodsDetail(goods.getGoodId());
		user = userService.selectByUserId(goods.getUserId());
		if (goods == null) {
			msg = "该商品不存在！";
			list = goodsService.showGoodsAllClient();
		} else {
			list = null;
		}

		return "clientdetailedInfo";
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
