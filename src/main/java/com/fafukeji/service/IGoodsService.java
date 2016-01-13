package com.fafukeji.service;

import com.fafukeji.V1.GoodsResult;
import com.fafukeji.model.Evaluate;
import com.fafukeji.model.Goods;

import java.util.List;

/**
 * Created by java on 2015/7/30 0030.
 */
public interface IGoodsService {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    List<Goods> getAll();
    List<Goods> selectGoods(Goods goods);
}
