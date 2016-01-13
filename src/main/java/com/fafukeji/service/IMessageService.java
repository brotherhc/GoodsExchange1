package com.fafukeji.service;

import com.fafukeji.model.Message;

import java.util.List;

/**
 * Created by fafukeji_java on 2015/7/23.
 */
public interface IMessageService {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectMessage(Message message);
}
