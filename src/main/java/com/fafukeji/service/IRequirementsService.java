package com.fafukeji.service;

import com.fafukeji.model.Goods;
import com.fafukeji.model.Requirements;
import com.fafukeji.model.RequirementsGoods;

import java.util.List;

/**
 * Created by java on 2015/7/30 0030.
 */
public interface IRequirementsService{
    int deleteByPrimaryKey(Integer id);

    int insert(Requirements record);

    int insertSelective(Requirements record);

    Requirements selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Requirements record);

    int updateByPrimaryKey(Requirements record);
    List<Requirements> getAll();
    List<Requirements> selectRequirements(Requirements requirements);
    List<Requirements>selectid(Requirements requirements);
}
