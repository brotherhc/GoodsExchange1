package com.fafukeji.service.impl;

import com.fafukeji.dao.EvaluateAboveMapper;
import com.fafukeji.dao.EvaluateMapper;
import com.fafukeji.model.Evaluate;
import com.fafukeji.model.EvaluateAbove;
import com.fafukeji.service.IEvaluateAboveService;
import com.fafukeji.service.IEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fafukeji_java on 2015/7/28.
 */
@Service
public class EvaluateAboveServiceImpl implements IEvaluateAboveService{
    @Autowired
    private EvaluateAboveMapper evaluateAboveMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return evaluateAboveMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(EvaluateAbove record) {
        return evaluateAboveMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(EvaluateAbove record) {
        return evaluateAboveMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<EvaluateAbove> selectEvaluateAbove(EvaluateAbove evaluateAbove) {
        return evaluateAboveMapper.selectEvaluateAbove(evaluateAbove);
    }
}
