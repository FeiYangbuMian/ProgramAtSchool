package com.itshixun.service;

import java.util.List;

import com.itshixun.entity.Comments;

public interface CommentsService {
	/**
	 * 作为DAO的接口
	 * @param comments
	 * @return
	 */
	public abstract int insertComments(Comments comments);
	public  List<Comments> findComments(int userId);
	public  List<Comments> selectComments();

}
