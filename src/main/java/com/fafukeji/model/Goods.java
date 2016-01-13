package com.fafukeji.model;

import com.fafukeji.common.persistence.DataEntity;
import com.fafukeji.common.persistence.Page;

public class Goods extends DataEntity{
    private Integer id;

    private User userId;

    private Categories categoryId;//分类id

    private String description;//描述

    private String attributes;//关键字

    private String pics;//需求图片
    private String urls;//需求URL

    private Integer numbers;//物品数量

    private Integer state;//物品状态

    private Integer status;//默认0，删除1

    private String taskStateName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Categories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Categories categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes == null ? null : attributes.trim();
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                ", description='" + description + '\'' +
                ", attributes='" + attributes + '\'' +
                ", pics='" + pics + '\'' +
                ", urls='" + urls + '\'' +
                ", numbers=" + numbers +
                ", state=" + state +
                ", status=" + status +
                ", taskStateName='" + taskStateName + '\'' +
                '}';
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls == null ? null : urls.trim();
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
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

    public String getTaskStateName() {
        return taskStateName;
    }

    public void setTaskStateName(String taskStateName) {
        this.taskStateName = taskStateName;
    }

}