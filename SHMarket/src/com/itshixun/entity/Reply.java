package com.itshixun.entity;
/*#
# Source for table "t_reply"
#

CREATE TABLE `t_reply` (
  `replyId` int(11) NOT NULL auto_increment,
  `userId` int(11) NOT NULL,
  `goodId` int(11) NOT NULL,
  `commmentId` int(11) NOT NULL,
  `reply_content` varchar(500) NOT NULL,
  `writeTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`replyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



*/

import java.sql.Timestamp;

public class Reply {
	private int replyId;
	private int userId;
	private int commentId;
	private String replyContent;
	private Timestamp writeTime;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Timestamp getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Timestamp writeTime) {
		this.writeTime = writeTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
