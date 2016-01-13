package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.Requirements;

import java.util.List;

@MyBatisDao
public interface RequirementsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Requirements record);

    int insertSelective(Requirements record);

    Requirements selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Requirements record);
    List<Requirements>selectid(Requirements requirements);
    int updateByPrimaryKey(Requirements record);
    List<Requirements> getAll();
    List<Requirements> selectRequirements(Requirements requirements);
}