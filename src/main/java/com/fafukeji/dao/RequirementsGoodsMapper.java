package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.RequirementsGoods;

import java.util.List;
@MyBatisDao
public interface RequirementsGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RequirementsGoods record);

    int insertSelective(RequirementsGoods record);

    RequirementsGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RequirementsGoods record);

    int updateByPrimaryKey(RequirementsGoods record);
    List<RequirementsGoods> selectRequirementsGoods(RequirementsGoods requirementsGoods);
}