package com.itshixun.entity;

//create table t_user(
//userId int PRIMARY KEY AUTO_INCREMENT,/*用户ID*/
//userName varchar(10) NOT NULL,/*用户名*/
//userPwd varchar(20) NOT NULL check(userPwd>8),/*用户密码*/
//userAddress varchar(50) NOT NULL default 0,/*用户地址*/
//userEmail varchar(20) NOT NULL,/*用户邮件 */
//userPhoto varchar(255) NOT NULL,/*用户照片 */
//userQQ varchar(20) NOT NULL default 0,/*用户QQ */
//userIntegral int NOT NULL default 0,/*用户积分 */
//userPhone varchar(20) NOT NULL default 0,/*用户联系方式*/
//userAccount varchar(255) NOT NULL default 0/*用户账户 */
public class User {
	private int userId;
	private String userName;
	private String userPwd;
	private String userAddress;
	private String userEmail;
	private String userPhoto;
	private int userIntegral;
	private String userQQ;
	private String userPhone;
	private String userAccount;
	private String userStatus;

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getUserQQ() {
		return userQQ;
	}

	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}

	public int getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

}
