package com.itshixun.service;

import java.util.List;

import com.itshixun.entity.GoodsClass;


public interface GoodsClassService {
    
	public abstract int insertGoodsClass(GoodsClass goodsClass);
	public  List<GoodsClass> selectGoodsClass();
	public abstract int deleteGoodsClass(int classId);
}
