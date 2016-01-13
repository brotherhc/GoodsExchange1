package com.fafukeji.model;

import com.fafukeji.common.persistence.DataEntity;

public class Match extends DataEntity {
    private Integer id;

    private Integer requirementId;

    private Integer requirementUserId;

    private Integer goodsId;

    private Integer goodsUserId;

    private Boolean type;

    private Integer matchId;

    private Boolean state;

    private Boolean status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }

    public Integer getRequirementUserId() {
        return requirementUserId;
    }

    public void setRequirementUserId(Integer requirementUserId) {
        this.requirementUserId = requirementUserId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsUserId() {
        return goodsUserId;
    }

    public void setGoodsUserId(Integer goodsUserId) {
        this.goodsUserId = goodsUserId;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
