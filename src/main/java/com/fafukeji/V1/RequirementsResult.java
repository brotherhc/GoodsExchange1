package com.fafukeji.V1;

import com.fafukeji.model.Requirements;

/**
 * 需求
 */
public class RequirementsResult implements RequirementsDao{
    private int result=1;//状态
    private String msg;//返回信息
    private Object data;//数据

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    private Integer id;
    private Integer userId;
    private Integer categoryId;
    private String description;
    private String attributes;
    private String pics;
    private String urls;
    private Integer state;
    private Integer status;
    public RequirementsResult RequirementsInfo(Requirements rs){
        this.setId(rs.getId());
        this.setUserId(rs.getUserId());
        this.setCategoryId(rs.getCategoryId());
        this.setDescription(rs.getDescription());
        this.setAttributes(rs.getAttributes());
        this.setPics(rs.getPics());
        this.setUrls(rs.getUrls());
        this.setState(rs.getState());
        this.setStatus(rs.getStatus());
        return this;
    }
}
