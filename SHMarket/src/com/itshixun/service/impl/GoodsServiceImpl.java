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

	public int insertGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.insertGoods(goods);
	}

	public List<Goods> showGoodsAllClient() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsAllClient();
	}

	public List<Goods> showGoodsAll() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsAll();
	}

	public int deleteGoodsById(int goodId) {
		// TODO Auto-generated method stub
		return goodsDao.deleteGoodsById(goodId);
	}

	public int updateGoodsById(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.updateGoodsById(goods);
	}

	public Goods selectGoodsByIdClient(int goodId) {
		// TODO Auto-generated method stub
		return goodsDao.selectGoodsByIdClient(goodId);
	}

	public Goods selectGoodsById(int goodId) {
		// TODO Auto-generated method stub
		return goodsDao.selectGoodsById(goodId);
	}

	public int updateGoodState(int goodId) {
		// TODO Auto-generated method stub
		return goodsDao.updateGoodState(goodId);
	}

	public int updateGoodStation(int goodId) {
		// TODO Auto-generated method stub
		return goodsDao.updateGoodStation(goodId);
	}

	public List<Goods> showGoodsStation() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsStation();
	}

	public List<Goods> showGoodsDigital() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsDigital();
	}

	public List<Goods> showGoodsFour() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsFour();
	}

	public List<Goods> showGoodsCream() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsCream();
	}

	public List<Goods> showGoodsLip() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsLip();
	}

	public List<Goods> showGoodsFitting() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsFitting();
	}

	public List<Goods> showGoodsSkincare() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsSkincare();
	}

	public List<Goods> showGoodsMakeup() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsMakeup();
	}

	public List<Goods> showGoodsPad() {
		// TODO Auto-generated method stub
		return goodsDao.showGoodsPad();
	}

	public Goods selectGoodsDetail(int goodId) {
		// TODO Auto-generated method stub
		return goodsDao.selectGoodsDetail(goodId);
	}

	@Override
	public List<Goods> selectGoodsByUserId(int userId) {
		// TODO Auto-generated method stub
		return goodsDao.selectGoodsByUserId(userId);
	}

	@Override
	public Goods findGoodsById(int goodId) {
		// TODO Auto-generated method stub
		return goodsDao.findGoodsById(goodId);
	}

	@Override
	public int updateGoodsPhoto(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.updateGoodsPhoto(goods);
	}

}
