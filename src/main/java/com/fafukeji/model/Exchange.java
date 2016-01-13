package com.fafukeji.model;

public class Exchange {
    private Integer id;

    private Integer matchId;

    private Integer matchUserId;

    private Integer matchedId;

    private Integer matchedUserId;

    private Boolean state;

    private Boolean status;

    private Integer updatedAt;

    private Integer createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getMatchUserId() {
        return matchUserId;
    }

    public void setMatchUserId(Integer matchUserId) {
        this.matchUserId = matchUserId;
    }

    public Integer getMatchedId() {
        return matchedId;
    }

    public void setMatchedId(Integer matchedId) {
        this.matchedId = matchedId;
    }

    public Integer getMatchedUserId() {
        return matchedUserId;
    }

    public void setMatchedUserId(Integer matchedUserId) {
        this.matchedUserId = matchedUserId;
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

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }
}