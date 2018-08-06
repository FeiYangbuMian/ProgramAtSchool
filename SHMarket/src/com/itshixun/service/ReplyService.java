package com.itshixun.service;

import java.util.List;

import com.itshixun.entity.Reply;

public interface ReplyService {
	/**
	 * 作为DAO的接口
	 * @param reply
	 * @return
	 */
	public abstract int insertReply(Reply reply);
	public  List<Reply> selectReply(int commmentsId);
	public  abstract int deleteReply(int replyId);
	public Reply selectByReplyId(int replyId);

}
