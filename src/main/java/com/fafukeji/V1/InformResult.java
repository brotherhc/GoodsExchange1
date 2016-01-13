package com.fafukeji.V1;

/**
 * Created by java on 2015/8/27 0027.
 */
public class InformResult {
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

    private Integer userId;

    private Integer goodsId;

    private Integer informedUserId;

    private String content;

    private Boolean type;

    private Boolean status;
    public InformResult infrominfo(InformResult inform){
        this.setId(inform.getId());
        this.setUserId(inform.getUserId());
        this.setGoodsId(inform.getGoodsId());
        this.setInformedUserId(inform.getInformedUserId());
        this.setContent(inform.getContent());
        this.setType(inform.getType());
        this.setStatus(inform.getStatus());
        return this;
    }
}
