package com.itshixun.dao;

import java.util.List;
import com.itshixun.entity.Reply;

public interface ReplyDao {
	public abstract int insertReply(Reply reply);
	public List<Reply> selectReply(int commmentsId);
	public abstract int deleteReply(int replyId);
	public Reply selectByReplyId(int replyId);


}
