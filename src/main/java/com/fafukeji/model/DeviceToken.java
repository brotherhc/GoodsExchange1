package com.fafukeji.model;

import com.fafukeji.common.persistence.DataEntity;

public class DeviceToken extends DataEntity<DeviceToken>  {
	private static final long serialVersionUID = -1919563096283525380L;
	private Integer id;

    private Integer userId;

    private String deviceToken;

    private Byte deviceType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken == null ? null : deviceToken.trim();
    }

    public Byte getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Byte deviceType) {
        this.deviceType = deviceType;
    }



    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }


}