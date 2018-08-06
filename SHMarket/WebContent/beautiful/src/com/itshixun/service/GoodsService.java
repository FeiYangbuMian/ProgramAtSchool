package com.itshixun.service;

import java.util.List;

import com.itshixun.entity.Goods;

public interface GoodsService {

	public abstract int insertGoods(Goods goods);
	public abstract List<Goods> showGoodsAll();
	public abstract int deleteGoodsById(int goodId);
	public abstract int updateGoodsById(Goods goods);
	public abstract Goods selectGoodsById(int goodId);
}