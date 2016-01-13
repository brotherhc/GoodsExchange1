package com.fafukeji.service.impl;

import com.fafukeji.dao.CategoriesMapper;
import com.fafukeji.model.Categories;
import com.fafukeji.service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fafukeji on 2015/8/4.
 */

@Service
public class CategoriesServiceImpl implements ICategoriesService {

    @Autowired
    private CategoriesMapper categoriesMapper;
    @Override
    public String deleteByPrimaryKey(Integer id) {
        if(categoriesMapper.deleteByPrimaryKey(id) == 1){
            return "删除成功";
        }else return "删除失败";

    }


    @Override
    public int insert(Categories record) {
        return categoriesMapper.insert(record);
    }

    @Override
    public int insertSelective(Categories record) {
        return categoriesMapper.insertSelective(record);
    }

    @Override
    public Categories selectByPrimaryKey(Integer id) {
        return categoriesMapper.selectByPrimaryKey(id);
    }

    @Override
    public String updateByPrimaryKeySelective(Categories record) {
        if(categoriesMapper.updateByPrimaryKey(record) == 1){


            return "修改成功";
        }else return "修改失败";
    }

    @Override
    public String updateByPrimaryKey(Categories record) {
        if(categoriesMapper.updateByPrimaryKey(record) == 1){
            return "修改成功";
        }else return "修改失败";
    }

    @Override
    public List<Categories> getAll() {
        return  categoriesMapper.getAll();
    }

    @Override
    public List<Categories> findname(Categories categories) {
        return categoriesMapper.findname(categories);
    }

    @Override
    public List<Categories> findtwo(String name) {
        return categoriesMapper.findtwo(name);
    }


    @Override
    public List<Categories> findtthree(Categories categories) {
        return categoriesMapper.findtthree(categories);
    }


    @Override
    public Categories selectByEname(String ename) {
        return categoriesMapper.selectByEname(ename);
    }
}
