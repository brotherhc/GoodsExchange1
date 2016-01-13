package com.fafukeji.service;

import com.fafukeji.model.Categories;
import com.fafukeji.model.User;

import java.util.List;

/**
 * Created by fafukeji on 2015/8/4.
 */
public interface ICategoriesService {
    String deleteByPrimaryKey(Integer id);

    int insert(Categories record);

    int insertSelective(Categories record);

    Categories selectByPrimaryKey(Integer id);

    String updateByPrimaryKeySelective(Categories record);

    String updateByPrimaryKey(Categories record);

    List<Categories> getAll();

    List<Categories>findname(Categories categories);
    List<Categories> findtwo(String name);
    List<Categories>findtthree(Categories categories);
    Categories selectByEname(String ename);
}
