package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.Categories;

import java.util.List;

@MyBatisDao
public interface CategoriesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Categories record);

    int insertSelective(Categories record);

    Categories selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Categories record);

    int updateByPrimaryKey(Categories record);
    List<Categories> findtwo(String name);
    List<Categories> getAll();
    List<Categories>findtthree(Categories categories);
    List<Categories>findname(Categories categories);
    Categories selectByEname(String ename);
}