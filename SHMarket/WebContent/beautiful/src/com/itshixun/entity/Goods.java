package com.itshixun.entity;

import java.sql.Timestamp;

public class Goods {
	/*goodId int PRIMARY KEY AUTO_INCREMENT,��ƷID
	goodName varchar(20) NOT NULL,��Ʒ����
	goodPhoto varchar(255) NOT NULL,��ƷͼƬ
	goodInfo varchar(255) NOT NULL,��Ʒ����
	goodPrice float NOT NULL check(goodPrice>0),��Ʒ�۸�
	tradeType int NOT NULL default 1,��������
	pubDate timestamp default now() NOT NULL,����ʱ��
	userId int NOT NULL,�û�ID
	classId int NOT NULL,���ID
	goodPraise float NOT NULL check(goodPraise>=0)��Ʒ�ȶ�*/
	
	private int goodId;//��ƷID
	private String goodName;//��Ʒ����
	private String goodPhoto;//��ƷͼƬ
	private String goodInfo;//��Ʒ����
	private float goodPrice;//��Ʒ�۸�
	private int tradeType;//��������
	private Timestamp pubDate;//����ʱ��
	private int userId;//�û�ID
	private int classId;//���ID
	private String className;
	private float goodPraise;//��Ʒ�ȶ�
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
