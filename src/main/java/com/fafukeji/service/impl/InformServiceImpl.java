package com.fafukeji.service.impl;

import com.fafukeji.dao.InformMapper;
import com.fafukeji.model.Inform;
import com.fafukeji.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by java on 2015/7/28 0028.
 */
@Service
public class InformServiceImpl implements InformService {



    @Autowired
    private InformMapper informMapper;


    @Override
    public Inform selectByPrimaryKey(Integer id) {
        return informMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Inform> selectinform(Inform inform) {
        return  informMapper.selectinform(inform);
    }

    @Override
    public List<Inform> getAll() {
        return informMapper.getAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return informMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Inform inform) {
        return informMapper.insert(inform);
    }

    @Override
    public int insertSelective(Inform inform) {
        return informMapper.insertSelective(inform);
    }

    @Override
    public int updateByPrimaryKeySelective(Inform inform) {
        return informMapper.updateByPrimaryKeySelective(inform);
    }

    @Override
    public int updateByPrimaryKey(Inform inform) {
        return informMapper.updateByPrimaryKey(inform);
    }

    @Override
    public Integer deleteInformById(Integer id) {
        return informMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Inform> selecteid(Inform inform) {
        return informMapper.selecteid(inform);
    }
}
