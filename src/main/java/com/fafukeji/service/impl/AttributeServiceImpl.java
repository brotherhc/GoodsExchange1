package com.fafukeji.service.impl;

import com.fafukeji.dao.AttributeMapper;
import com.fafukeji.model.Attribute;
import com.fafukeji.service.IAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeServiceImpl implements IAttributeService{

    @Autowired
    private AttributeMapper attributeMapper;

    @Override
    public String deleteByPrimaryKey(Integer id) {
        if(attributeMapper.deleteByPrimaryKey(id) == 1){
            return "删除成功";
        }else return "删除失败";

    }

    @Override
    public int insert(Attribute record) {
        return attributeMapper.insert(record);
    }

    @Override
    public int insertSelective(Attribute record) {
        return attributeMapper.insertSelective(record);
    }

    @Override
    public Attribute selectByPrimaryKey(Integer id) {
        return attributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Attribute attribute) {
        return  attributeMapper.updateByPrimaryKeySelective(attribute);
    }


    @Override
    public String updateByPrimaryKey(Attribute record) {
        if(attributeMapper.updateByPrimaryKey(record) == 1){
            return "修改成功";
        }else return "修改失败";

    }

    @Override
    public List<Attribute> list() {
        return attributeMapper.list();
    }

    @Override
    public int selectCategoryByCategory_id(Integer Category_id) {
        return attributeMapper.selectCategoryBycategory_id(Category_id);
    }

    @Override
    public List<Attribute> selectid(Attribute requirements) {
        return  attributeMapper.selectid(requirements);
    }

    @Override
    public List<Attribute> selectattribute(Attribute attribute) {
        return  attributeMapper.selectattribute(attribute);
    }

    @Override
    public List<Attribute> listbyname(String name) {
        return attributeMapper.listbyname(name);
    }
}
