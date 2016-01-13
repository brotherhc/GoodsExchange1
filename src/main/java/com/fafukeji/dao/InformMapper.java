package com.fafukeji.dao;


import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.Inform;

import java.util.List;

@MyBatisDao
public interface InformMapper {
    List<Inform> getAll();
    List<Inform>selectinform(Inform inform);
    Inform selectByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
    int insert(Inform inform);
    int insertSelective(Inform inform);
    int updateByPrimaryKeySelective(Inform inform);
    int updateByPrimaryKey(Inform inform);
    List<Inform>selecteid(Inform inform);
}