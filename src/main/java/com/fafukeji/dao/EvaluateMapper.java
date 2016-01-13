package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.Evaluate;

import java.util.List;

@MyBatisDao
public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);

    List<Evaluate> selectEvaluate(Evaluate evaluate);
    List<Evaluate>selecte_id(Evaluate evaluate);
}