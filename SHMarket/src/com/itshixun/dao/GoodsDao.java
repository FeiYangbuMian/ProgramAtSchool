package com.itshixun.dao;

import java.util.List;

import com.itshixun.entity.Goods;

public interface GoodsDao {

	public abstract int insertGoods(Goods goods);
	public abstract List<Goods> showGoodsAllClient();
	public abstract List<Goods> showGoodsAll();
	public abstract List<Goods> showGoodsStation();
	public abstract int deleteGoodsById(int goodId);
	public abstract int updateGoodState(int goodId);
	public abstract int updateGoodStation(int goodId);
	public abstract int updateGoodsById(Goods goods);
	public abstract int updateGoodsPhoto(Goods goods);
	public abstract Goods findGoodsById(int goodId);
	public abstract Goods selectGoodsByIdClient(int goodId);
	public abstract Goods selectGoodsById(int goodId);
	public abstract List<Goods> selectGoodsByUserId(int userId);
	public abstract Goods selectGoodsDetail(int goodId);
	public abstract List<Goods> showGoodsDigital();
	public abstract List<Goods> showGoodsPad();
	public abstract List<Goods> showGoodsFitting();
	public abstract List<Goods> showGoodsSkincare();
	public abstract List<Goods> showGoodsMakeup();
	public abstract List<Goods> showGoodsFour();
	public abstract List<Goods> showGoodsCream();
	public abstract List<Goods> showGoodsLip();
}
