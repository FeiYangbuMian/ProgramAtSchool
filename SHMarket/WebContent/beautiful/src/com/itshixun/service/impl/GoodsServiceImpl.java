package com.itshixun.service.impl;

import java.util.List;

import com.itshixun.dao.GoodsDao;
import com.itshixun.entity.Goods;
import com.itshixun.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	public GoodsDao goodsDao = null;
	
	
	public GoodsDao getGoodsDao() {
		return goodsDao;
	}


	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}


	@Override
	public int insertGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.insertGoods(goods);
	}


	@Override
	public List<Goods> showGoodsAll() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsAll();
	}


	@Override
	public int deleteGoodsById(int goodId) {
		// TODO Auto-generated method stub
		return goodsDao.deleteGoodsById(goodId);
	}


	@Override
	public int updateGoodsById(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.updateGoodsById(goods);
	}


	@Override
	public Goods selectGoodsById(int goodId) {
		// TODO Auto-generated method stub
		return goodsDao.selectGoodsById(goodId);
	}


	

}
