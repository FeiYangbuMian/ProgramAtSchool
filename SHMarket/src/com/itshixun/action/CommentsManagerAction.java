package com.itshixun.action;

import java.util.List;
import java.util.Map;

import com.itshixun.entity.Comments;
import com.itshixun.entity.Reply;
import com.itshixun.entity.User;
import com.itshixun.service.CommentsService;
import com.itshixun.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class CommentsManagerAction extends ActionSupport{
	public Comments comments;
	public User user;
	public CommentsService commentsService;
	public UserService userService;
	public List<Comments> commentsList;
	public List<Reply> replyList;
	public Map<String,Object> session;
	
	public Comments getComments() {
		return comments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CommentsService getCommentsService() {
		return commentsService;
	}
	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Comments> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}
	
	public List<Reply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	private String msg;

	
	public String registerComments(){
		int count = commentsService.insertComments(comments);
		commentsList = commentsService.findComments(comments.getUserId());
		if(count>0){
			return "customSer";
		}else{
		return ERROR;
		}
	}
	public String findComments(){
		msg = null;
		commentsList = commentsService.findComments(comments.getUserId());
		if(commentsList.size() == 0){
			msg = "您还没有提意见哦^~^";
		}else{
			replyList = null;
		}
		return "customSer";
	}
	
	public String selectComments(){
		commentsList = commentsService.selectComments();
		if(commentsList != null){
			return "servershow";
		}else{
			return "serversuccess";
		}
		
	}
	
}
