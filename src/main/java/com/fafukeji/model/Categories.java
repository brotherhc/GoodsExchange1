package com.fafukeji.model;

import com.fafukeji.common.persistence.DataEntity;

public class Categories extends DataEntity<Categories>{

    private Integer id;

    private String name;//中文名字

    private String ename;//英文名称

    private String enamePath;//层级路径

    private Integer parentId;//父级id

    private String categoryId;//分类id

    private String parentName;//父级名字

    private Short level;//等级

    private Short ordinal;//排序字段

    private Byte disableState;//启用状态：0->默认启用，1->禁用

    private Boolean status;//默认0，删除1

    private Integer updatedAt;

    private Integer createdAt;


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getEnamePath() {
        return enamePath;
    }

    public void setEnamePath(String enamePath) {
        this.enamePath = enamePath == null ? null : enamePath.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Short getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Short ordinal) {
        this.ordinal = ordinal;
    }

    public Byte getDisableState() {
        return disableState;
    }

    public void setDisableState(Byte disableState) {
        this.disableState = disableState;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


}