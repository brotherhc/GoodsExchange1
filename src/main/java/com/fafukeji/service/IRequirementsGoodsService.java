package com.fafukeji.service;

import com.fafukeji.model.RequirementsGoods;

import java.util.List;

/**
 * Created by java on 2015/8/5 0005.
 */
public interface IRequirementsGoodsService {
    int deleteByPrimaryKey(Integer id);

    int insert(RequirementsGoods record);

    int insertSelective(RequirementsGoods record);

    RequirementsGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RequirementsGoods record);

    int updateByPrimaryKey(RequirementsGoods record);
    List<RequirementsGoods> selectRequirementsGoods(RequirementsGoods requirementsGoods);
}
