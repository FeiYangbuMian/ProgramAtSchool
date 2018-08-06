package com.itshixun.action;

import java.util.List;
import java.util.Map;

import com.itshixun.entity.Comments;
import com.itshixun.entity.Reply;
import com.itshixun.service.CommentsService;
import com.itshixun.service.ReplyService;
import com.opensymphony.xwork2.ActionSupport;

public class ReplyManagerAction extends ActionSupport{
	public Reply reply;
	public Comments comments;
	public ReplyService replyService;
	public CommentsService commentsService;
	public List<Reply> replyList;
	public List<Comments> commentsList;
	public Map<String,Object> session;
	
	
	
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}
	public Comments getComments() {
		return comments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	public ReplyService getReplyService() {
		return replyService;
	}
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	public CommentsService getCommentsService() {
		return commentsService;
	}
	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Reply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	public List<Comments> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	private String msg;
	public String execute(){
		return "register";
	}
	
	
	public String selectReply(){
		commentsList = commentsService.findComments(comments.getUserId());
		replyList = replyService.selectReply(reply.getCommentId());
		if(replyList.size() == 0){
			msg = "管理员还没有对您的意见进行回复哦,请耐心等待^~^";
		}
		return "customSer";
		
	}
	public String registerReply(){
		int count = replyService.insertReply(reply);
		if(count>0){
			commentsList = commentsService.selectComments();
			return "servershow";
		}else{
		return ERROR;
		}
	}
}
