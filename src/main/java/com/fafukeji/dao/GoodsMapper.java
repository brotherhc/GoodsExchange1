package com.fafukeji.dao;

import com.fafukeji.V1.GoodsResult;
import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.Goods;

import java.util.List;

@MyBatisDao
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> getAll();
    List<Goods>selectGoods(Goods goods);
}