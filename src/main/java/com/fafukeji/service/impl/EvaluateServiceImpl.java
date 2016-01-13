package com.fafukeji.service.impl;

import com.fafukeji.dao.EvaluateMapper;
import com.fafukeji.model.Evaluate;
import com.fafukeji.service.IEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fafukeji_java on 2015/7/24.
 */
@Service("evaluateService")
public class EvaluateServiceImpl implements IEvaluateService{

    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return evaluateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Evaluate record) {
        return 0;
    }

    @Override
    public int insertSelective(Evaluate record) {
        return evaluateMapper.insertSelective(record);
    }

    @Override
    public Evaluate selectByPrimaryKey(Integer id) {
        return evaluateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Evaluate record) {
        return evaluateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Evaluate record) {
        return evaluateMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Evaluate> selectEvaluate(Evaluate evaluate) {
        return evaluateMapper.selectEvaluate(evaluate);
    }

    @Override
    public List<Evaluate> selecte_id(Evaluate evaluate) {
        return evaluateMapper.selecte_id(evaluate);
    }
}
