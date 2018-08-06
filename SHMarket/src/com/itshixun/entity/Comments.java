package com.itshixun.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Comments {
	/*创建商品评论表*/
	//create table t_commments(
	//commmentId int PRIMARY KEY AUTO_INCREMENT,/*评论id*/
	//goodId int NOT NULL,/*商品id*/
	//content  varchar(500) NOT NULL,/*评论内容*/
	//userId int NOT NULL,/*用户id*/
	//writeTime timestamp default now() NOT NULL/*评论时间*/
	//);
	private int commentId;
	private String goodName;
	private String content;
	private int userId;
	private String userName;
	private Timestamp writeTime;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Timestamp writeTime) {
		this.writeTime = writeTime;
	}
	
}
