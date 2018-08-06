package com.itshixun.service.impl;

import java.util.List;

import com.itshixun.dao.CommentsDao;
import com.itshixun.entity.Comments;
import com.itshixun.service.CommentsService;

public class CommentsServiceImpl implements CommentsService{
	public CommentsDao commentsDao = null;
	
	public CommentsDao getCommentsDao() {
		return commentsDao;
	}
	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}
	public int insertComments(Comments comments){
		return commentsDao.insertComments(comments);
	}
	public  List<Comments> findComments(int userId){
		return commentsDao.findComments(userId);
		
	}
	public  List<Comments> selectComments(){
		return commentsDao.selectComments();
		
	}
}
