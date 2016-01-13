package com.fafukeji.model;

import com.fafukeji.common.persistence.DataEntity;

public class UserLog extends DataEntity<UserLog> {
	private static final long serialVersionUID = 1L;

	private String id;

    private Integer userId;

    private String type;

    private String remoteAddr;

    private String requestUri;

    private String method;
    
    private String params;

    private String exception;
    
	
	// 日志类型（0：后台；1：app接口）
	public static final String TYPE_ADMIN = "0";
	public static final String TYPE_APP = "1";
	

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr == null ? null : remoteAddr.trim();
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception == null ? null : exception.trim();
    }

	public long getCreatedAt() {
		return createdAt;
	}

}