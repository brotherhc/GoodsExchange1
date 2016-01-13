package com.fafukeji.service;

import com.fafukeji.model.Inform;

import java.util.List;

/**
 * Created by java on 2015/7/28 0028.
 */
public interface InformService {
        Inform selectByPrimaryKey(Integer id);
        List<Inform>selectinform(Inform inform);
        List<Inform> getAll();
        int deleteByPrimaryKey(Integer id);
        int insert(Inform inform);
        int insertSelective(Inform inform);
        int updateByPrimaryKeySelective(Inform inform);
        int updateByPrimaryKey(Inform inform);
        Integer deleteInformById(Integer id);
        List<Inform>selecteid(Inform inform);
}
