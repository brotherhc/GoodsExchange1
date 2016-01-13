package com.fafukeji.model;

import com.fafukeji.common.persistence.DataEntity;

public class EvaluateAbove extends DataEntity<EvaluateAbove> {
    private Integer id;

    private User userId;

    private Evaluate evaluateId;

    private String content;

    private Boolean state;

    private Boolean status;

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

    public Evaluate getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Evaluate evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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