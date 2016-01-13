package com.fafukeji.service;

import com.fafukeji.model.Evaluate;

import java.util.List;

/**
 * Created by fafukeji_java on 2015/7/24.
 */
public interface IEvaluateService {
    int deleteByPrimaryKey(Integer id);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);

    List<Evaluate> selectEvaluate(Evaluate evaluate);
    List<Evaluate>selecte_id(Evaluate evaluate);
}
