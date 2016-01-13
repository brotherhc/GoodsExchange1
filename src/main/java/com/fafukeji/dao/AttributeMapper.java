package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.Attribute;

import java.util.List;

@MyBatisDao
public interface AttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    Attribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attribute attribute);

    int updateByPrimaryKey(Attribute record);

    List<Attribute> list();
    List<Attribute>selectattribute(Attribute attribute);
    List<Attribute> listbyname(String name);

    List<Attribute>selectid(Attribute requirements);
    int selectCategoryBycategory_id(Integer id);



}