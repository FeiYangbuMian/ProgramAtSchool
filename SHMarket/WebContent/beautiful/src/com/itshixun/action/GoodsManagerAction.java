package com.itshixun.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.itshixun.entity.Goods;
import com.itshixun.service.GoodsService;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsManagerAction extends ActionSupport implements SessionAware{
	public Goods goods;
	public Map<String,Object> session;
	public GoodsService goodsService;
	public List<Goods> list;
	public String msg;
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
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
	
	
	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	public String insertGoods(){
		int count = goodsService.insertGoods(goods);
		if(count>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String showGoodsAll(){
		list = goodsService.showGoodsAll();
		return "showGoodsAll";
		
	}
	
	public String deleteGoodsById(){
		int count = goodsService.deleteGoodsById(goods.getGoodId());
		if(count>0){
			list = goodsService.showGoodsAll();
		}else{
			System.out.println("删除失败！");
		}
		return "showGoodsAll";
	}
	
	public String selectGoodsById(){
		msg = null;
		goods = goodsService.selectGoodsById(goods.getGoodId());
		if(goods == null){
			msg = "该用户不存在！";
			list = goodsService.showGoodsAll();
			return "showGoodsAll";
		}else{
			return "updateGoods";
		}	
	}
	
	public String updateGoodsById(){
		int count=goodsService.updateGoodsById(goods);
		if(count>0){
			msg = "修改用户成功！";
		}else{
			msg = "修改用户失败！";
		}
		list = goodsService.showGoodsAll();
		return "showGoodsAll";
		
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
