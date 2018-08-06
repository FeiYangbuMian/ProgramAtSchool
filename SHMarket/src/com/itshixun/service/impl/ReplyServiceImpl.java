package com.itshixun.service.impl;

import java.util.List;

import com.itshixun.dao.ReplyDao;
import com.itshixun.entity.Reply;
import com.itshixun.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{
	public ReplyDao replyDao = null;
	public ReplyDao getReplyDao() {
		return replyDao;
	}
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	public int insertReply(Reply reply){
		return replyDao.insertReply(reply);
	}
	public  List<Reply> selectReply(int commmentsId){
		return replyDao.selectReply(commmentsId);
		
	}
	public int deleteReply(int replyId){
		return replyDao.deleteReply(replyId);
		
	}
	public Reply selectByReplyId(int replyId){
		return null;
	}

}
