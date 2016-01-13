package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.Goods;
import com.fafukeji.model.Match;

import java.util.List;

@MyBatisDao
public interface MatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Match record);

    int insertSelective(Match record);

    Match selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Match record);

    int updateByPrimaryKey(Match record);
    List<Match> selectMatch(Match match);
    List<Match> getAll();
}