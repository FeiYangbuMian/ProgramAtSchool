package com.itshixun.dao;

import java.util.List;

import com.itshixun.entity.GoodsClass;
import com.itshixun.entity.GoodsClass;
 
 

public interface GoodsClassDao {

	public abstract int insertGoodsClass(GoodsClass goodsClass);
	public  List<GoodsClass> selectGoodsClass();
	public abstract int deleteGoodsClass(int classId);
	

}
