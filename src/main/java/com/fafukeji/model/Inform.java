package com.fafukeji.model;

import com.fafukeji.common.persistence.DataEntity;

public class Inform extends DataEntity<Inform> {
    private Integer id;

    private Integer userId;//举报用户id

    private Integer goodsId;

    private Integer informedUserId;//被举报物品对应的用户id

    private String content;

    private String type;//举报类型

    private Boolean status;

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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getInformedUserId() {
        return informedUserId;
    }

    public void setInformedUserId(Integer informedUserId) {
        this.informedUserId = informedUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}