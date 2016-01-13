package com.fafukeji.model;

/**
 * SessionInfo model
 * @author wjx
 *
 */
public class SessionInfo implements java.io.Serializable {

	private static final long serialVersionUID = -4309333450692401668L;
	private Integer userId;// user ID
	private String loginName;// loginName
	private byte delFlag;
	private byte isAdmin;
	private String username;
	
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	@Override
	public String toString() {
		return loginName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
