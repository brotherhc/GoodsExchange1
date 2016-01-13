package com.fafukeji.service;


import com.fafukeji.model.Attribute;

import java.util.List;

public interface  IAttributeService {


    String deleteByPrimaryKey(Integer id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    Attribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attribute attribute);

    String updateByPrimaryKey(Attribute record);

    List<Attribute> list();

    List<Attribute> listbyname(String name);

    int selectCategoryByCategory_id(Integer category_id);
    List<Attribute>selectid(Attribute requirements);
    List<Attribute>selectattribute(Attribute attribute);

}
