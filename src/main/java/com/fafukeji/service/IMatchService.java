package com.fafukeji.service;

import com.fafukeji.model.Goods;
import com.fafukeji.model.Match;

import java.util.List;

/**
 * Created by java on 2015/8/5 0005.
 */
public interface IMatchService {
    int deleteByPrimaryKey(Integer id);

    int insert(Match record);

    int insertSelective(Match record);

    Match selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Match record);

    int updateByPrimaryKey(Match record);
    List<Match> selectMatch(Match match);
    List<Match> getAll();
}
