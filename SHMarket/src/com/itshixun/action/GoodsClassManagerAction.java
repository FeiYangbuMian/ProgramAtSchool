 package com.itshixun.action;

 
import java.util.List;
import java.util.Map;

import com.itshixun.entity.GoodsClass;
import com.itshixun.service.GoodsClassService;
import com.opensymphony.xwork2.ActionSupport;
 

public class GoodsClassManagerAction extends ActionSupport {
	public GoodsClass goodsClass;
	public GoodsClassService goodsClassService;
	public List<GoodsClass> goodsClassList;
	public Map<String,Object> session;
	private String msg;
	public Map<String,Object> request;
 
	 
	public GoodsClassService getGoodsClassService() {
		return goodsClassService;
	}


	public void setGoodsClassService(GoodsClassService goodsClassService) {
		this.goodsClassService = goodsClassService;
	}
	


	public List<GoodsClass> getGoodsClassList() {
		return goodsClassList;
	}


	public void setGoodsClassList(List<GoodsClass> goodsClassList) {
		this.goodsClassList = goodsClassList;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Map<String, Object> getRequest() {
		return request;
	}


	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}


	public String registerGoodsClass(){
		msg = null;
		int count = goodsClassService.insertGoodsClass(goodsClass);
		if(count>0){
			msg = "添加成功!";
		}else{
			msg = "添加失败!"; 
		}
		goodsClassList = goodsClassService.selectGoodsClass();
		return "show";
	}
	public String selectGoodsClass(){
		msg = null;
		goodsClassList = goodsClassService.selectGoodsClass();
		if(goodsClassList != null){
			return "show";
		}else{
			return "success";
		}
		
	}
	public String deleteGoodsClass(){
		msg = null;
		int count = goodsClassService.deleteGoodsClass(goodsClass.getClassId());
		if(count >0){
			goodsClassList = goodsClassService.selectGoodsClass();
			msg = "删除成功！";
		}else{
			msg = "删除失败！";
		}
		return "show";
	}
         

	public GoodsClass getGoodsClass() {
		return goodsClass;
	}


	public void setGoodsClass(GoodsClass goodsClass) {
		this.goodsClass = goodsClass;
	}

}
