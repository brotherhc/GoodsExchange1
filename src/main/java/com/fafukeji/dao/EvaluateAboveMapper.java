package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.EvaluateAbove;

import java.util.List;

@MyBatisDao
public interface EvaluateAboveMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(EvaluateAbove record);

    int updateByPrimaryKeySelective(EvaluateAbove record);

    List<EvaluateAbove> selectEvaluateAbove(EvaluateAbove evaluateAbove);
}