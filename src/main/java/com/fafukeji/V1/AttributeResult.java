package com.fafukeji.V1;

import com.fafukeji.V1.dao.AttributeDao;
import com.fafukeji.model.Attribute;

/**
 * Created by java on 2015/8/26 0026.
 */
public class AttributeResult implements AttributeDao{
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentName() {
        return parentName;
    }

    public void setParentName(Integer parentName) {
        this.parentName = parentName;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttributeNumber() {
        return attributeNumber;
    }

    public void setAttributeNumber(String attributeNumber) {
        this.attributeNumber = attributeNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private Integer id;
    private Integer categoryId;
    private String name;
    private Short level;
    private Integer parentId;
    private Integer parentName;
    private String attributeType;
    private String attributeNumber;
    private String status;
    public AttributeResult attributeinfo(Attribute attribute){
        this.setId(attribute.getId());
        this.setCategoryId(attribute.getCategoryId());
        this.setName(attribute.getName());
        this.setLevel(attribute.getLevel());
        this.setParentId(attribute.getParentId());
        this.setParentName(attribute.getParentName());
        this.setAttributeNumber(attribute.getAttributeNumber());
        this.setAttributeType(attribute.getAttributeType());
        this.setStatus(attribute.getStatus());
        return this;
    }

}
