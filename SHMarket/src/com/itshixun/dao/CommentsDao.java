package com.itshixun.dao;

import java.util.List;

import com.itshixun.entity.Comments;

public interface CommentsDao {
	public abstract int insertComments(Comments comments);
	public  List<Comments> findComments(int userId);
	public  List<Comments> selectComments();
}
