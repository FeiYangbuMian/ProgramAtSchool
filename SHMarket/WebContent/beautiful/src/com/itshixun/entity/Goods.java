package com.itshixun.entity;

import java.sql.Timestamp;

public class Goods {
	/*goodId int PRIMARY KEY AUTO_INCREMENT,商品ID
	goodName varchar(20) NOT NULL,商品名称
	goodPhoto varchar(255) NOT NULL,商品图片
	goodInfo varchar(255) NOT NULL,商品描述
	goodPrice float NOT NULL check(goodPrice>0),商品价格
	tradeType int NOT NULL default 1,交易类型
	pubDate timestamp default now() NOT NULL,发布时间
	userId int NOT NULL,用户ID
	classId int NOT NULL,类别ID
	goodPraise float NOT NULL check(goodPraise>=0)商品热度*/
	
	private int goodId;//商品ID
	private String goodName;//商品名称
	private String goodPhoto;//商品图片
	private String goodInfo;//商品描述
	private float goodPrice;//商品价格
	private int tradeType;//交易类型
	private Timestamp pubDate;//发布时间
	private int userId;//用户ID
	private int classId;//类别ID
	private String className;
	private float goodPraise;//商品热度
	public User user;
	public GoodsClass goodsClass;
	
	
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	public String getGoodPhoto() {
		return goodPhoto;
	}
	public void setGoodPhoto(String goodPhoto) {
		this.goodPhoto = goodPhoto;
	}
	public String getGoodInfo() {
		return goodInfo;
	}
	public void setGoodInfo(String goodInfo) {
		this.goodInfo = goodInfo;
	}
	public float getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(float goodPrice) {
		this.goodPrice = goodPrice;
	}
	public int getTradeType() {
		return tradeType;
	}
	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}
	public Timestamp getPubDate() {
		return pubDate;
	}
	public void setPubDate(Timestamp pubDate) {
		this.pubDate = pubDate;
	}
	public float getGoodPraise() {
		return goodPraise;
	}
	public void setGoodPraise(float goodPraise) {
		this.goodPraise = goodPraise;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public GoodsClass getGoodsClass() {
		return goodsClass;
	}
	public void setGoodsClass(GoodsClass goodsClass) {
		this.goodsClass = goodsClass;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
		
}
