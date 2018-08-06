package com.itshixun.entity;

import java.sql.Timestamp;

public class Orders {
	private int orderId;
	private int userId;
	private int goodId;
	private int orderCount;
	private String price;
	private String orderStatu;
	private Timestamp pubDate;
	private String userName;
	private String goodName;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOrderStatu() {
		return orderStatu;
	}
	public void setOrderStatu(String orderStatu) {
		this.orderStatu = orderStatu;
	}
	
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public Timestamp getPubDate() {
		return pubDate;
	}
	public void setPubDate(Timestamp pubDate) {
		this.pubDate = pubDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	

}
