package com.fafukeji.V1;

import com.fafukeji.V1.dao.EvaluateDao;
import com.fafukeji.model.User;

/**
 * Created by java on 2015/8/26 0026.
 */
public class EvaluateResult implements EvaluateDao{
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Integer exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    private Integer id;
    private User userId;
    private Integer goodsId;
    private Integer exchangeId;
    private String content;
    private Boolean type;
    private Boolean status;

    public EvaluateResult evaluateinfo(EvaluateResult evaluate){
        this.setId(evaluate.getId());
        this.setUserId(evaluate.getUserId());
        this.setGoodsId(evaluate.getGoodsId());
        this.setExchangeId(evaluate.getExchangeId());
        this.setContent(evaluate.getContent());
        this.setStatus(evaluate.getStatus());
        return this;
    }
}
