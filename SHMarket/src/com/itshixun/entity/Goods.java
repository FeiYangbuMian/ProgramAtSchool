package com.itshixun.entity;

import java.sql.Timestamp;

public class Goods {
	/*goodId int PRIMARY KEY AUTO_INCREMENT,
	goodName varchar(20) NOT NULL,
	goodPhoto varchar(255) NOT NULL,
	goodInfo varchar(255) NOT NULL,
	goodPrice float NOT NULL check(goodPrice>0),
	tradeType int NOT NULL default 1,
	pubDate timestamp default now() NOT NULL,
	userId int NOT NULL,
	classId int NOT NULL,
	goodPraise float NOT NULL check(goodPraise>=0)*/
	
	private int goodId;
	private String goodName;
	private String goodPhoto;
	private String goodInfo;
	private float goodPrice;
	private String tradeType;
	private Timestamp pubDate;
	private int userId;
	private int classId;
	private String className;
	private float goodPraise;
	public User user;
	public GoodsClass goodsClass;
	private String userName;
	
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
	
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
		
}
