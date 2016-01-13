package com.fafukeji.service.impl;

import com.fafukeji.dao.MatchMapper;
import com.fafukeji.model.Match;
import com.fafukeji.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by java on 2015/8/5 0005.
 */
@Service
public class MatchServiceImpl implements IMatchService {
    @Autowired
    private MatchMapper matchMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return matchMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Match record) {
        return matchMapper.insert(record);
    }

    @Override
    public int insertSelective(Match record) {
        return matchMapper.insertSelective(record);
    }

    @Override
    public Match selectByPrimaryKey(Integer id) {
        return matchMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Match record) {
        return matchMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Match record) {
        return matchMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Match> selectMatch(Match match) {
        return matchMapper.selectMatch(match);
    }

    @Override
    public List<Match> getAll() {
        return matchMapper.getAll();
    }
}
