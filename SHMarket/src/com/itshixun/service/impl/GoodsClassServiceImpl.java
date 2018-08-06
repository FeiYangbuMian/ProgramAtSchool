package com.itshixun.service.impl;

import java.util.List;

import com.itshixun.dao.GoodsClassDao;
 
import com.itshixun.entity.GoodsClass;

import com.itshixun.service.GoodsClassService;

public class GoodsClassServiceImpl implements GoodsClassService {
	public GoodsClassDao goodsClassDao = null;
	
	
	public GoodsClassDao getGoodsClassDao() {
		return goodsClassDao;
	}


	public void setGoodsClassDao(GoodsClassDao goodsClassDao) {
		this.goodsClassDao = goodsClassDao;
	}

	public int insertGoodsClass(GoodsClass goodsClass) {
		// TODO Auto-generated method stub
		return goodsClassDao.insertGoodsClass(goodsClass);
	}


	public  List<GoodsClass> selectGoodsClass(){
		return goodsClassDao.selectGoodsClass();
	}


	public int deleteGoodsClass(int classId) {
		// TODO Auto-generated method stub
		return goodsClassDao.deleteGoodsClass(classId);
	}
	   
}
