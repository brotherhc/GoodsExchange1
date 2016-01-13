package com.fafukeji.service.impl;

import com.fafukeji.V1.GoodsResult;
import com.fafukeji.dao.GoodsMapper;
import com.fafukeji.model.Goods;
import com.fafukeji.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by java on 2015/7/30 0030.
 */
@Service
public class GoodsServiceImpl implements IGoodsService{
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public int insertSelective(Goods record) {
        return goodsMapper.insertSelective(record);
    }

    @Override
    public Goods selectByPrimaryKey(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Goods> getAll() {
        return goodsMapper.getAll();
    }

    @Override
    public List<Goods> selectGoods(Goods goods) {
        return  goodsMapper.selectGoods(goods);
    }

}
