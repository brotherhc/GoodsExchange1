package com.fafukeji.service;

import com.fafukeji.model.EvaluateAbove;

import java.util.List;

/**
 * Created by fafukeji_java on 2015/7/28.
 */
public interface IEvaluateAboveService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(EvaluateAbove record);

    int updateByPrimaryKeySelective(EvaluateAbove record);

    List<EvaluateAbove> selectEvaluateAbove(EvaluateAbove evaluateAbove);
}
