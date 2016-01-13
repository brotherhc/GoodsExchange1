package com.fafukeji.model;

import com.fafukeji.common.persistence.DataEntity;



public class User extends DataEntity {
	private static final long serialVersionUID = 1L;

	public static final byte STATE_TASK = 0;
	
	public static final byte USER = 2;

	public static final byte ADMIN = 1;
	
	public static final byte AGENT
			= 1;
	private Integer id;




    private String username;

	private String mobile;//电话

	private String password;

	private String imei;//手机设备唯一标识码

	private String email;

	private String emailKey;//邮箱验证KEY

	private String isVerify;//邮箱验证是否通过

	private String accountType;//帐号类型

	private String thirdpartyAccountKey;//第三方帐号登录key

	private String userLevel;//用户评价等级

	private Integer userScore;//用户评价积分

	private String userLevelName;//用户等级名字

	private String state;//用户状态

	private byte isAdmin;//是否管理员

	private byte delFlag;//删除标记

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei == null ? null : imei.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getEmailKey() {
		return emailKey;
	}

	public void setEmailKey(String emailKey) {
		this.emailKey = emailKey == null ? null : emailKey.trim();
	}

	public String getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(String isVerify) {
		this.isVerify = isVerify == null ? null : isVerify.trim();
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getThirdpartyAccountKey() {
		return thirdpartyAccountKey;
	}

	public void setThirdpartyAccountKey(String thirdpartyAccountKey) {
		this.thirdpartyAccountKey = thirdpartyAccountKey == null ? null : thirdpartyAccountKey.trim();
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getUserScore() {
		return userScore;
	}

	public void setUserScore(Integer userScore) {
		this.userScore = userScore;
	}

	public String getUserLevelName() {
		return userLevelName;
	}

	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName == null ? null : userLevelName.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public byte getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(byte delFlag) {
		this.delFlag = delFlag;
	}
}