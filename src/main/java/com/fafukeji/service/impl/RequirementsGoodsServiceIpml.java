package com.fafukeji.service.impl;



import com.fafukeji.dao.RequirementsGoodsMapper;
import com.fafukeji.model.RequirementsGoods;
import com.fafukeji.service.IRequirementsGoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by java on 2015/8/5 0005.
 */
public class RequirementsGoodsServiceIpml implements IRequirementsGoodsService{
    @Autowired
    private RequirementsGoodsMapper requirementsGoodsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return requirementsGoodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RequirementsGoods record) {
        return requirementsGoodsMapper.insert(record);
    }

    @Override
    public int insertSelective(RequirementsGoods record) {
        return requirementsGoodsMapper.insertSelective(record);
    }

    @Override
    public RequirementsGoods selectByPrimaryKey(Integer id) {
        return requirementsGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RequirementsGoods record) {
        return requirementsGoodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RequirementsGoods record) {
        return requirementsGoodsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<RequirementsGoods> selectRequirementsGoods(RequirementsGoods requirementsGoods) {
        return requirementsGoodsMapper.selectRequirementsGoods(requirementsGoods);
    }


}
