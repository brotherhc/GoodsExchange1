package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.Message;

import java.util.List;

@MyBatisDao
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectMessage(Message message);
}