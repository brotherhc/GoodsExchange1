package com.fafukeji.service.impl;

import com.fafukeji.dao.MessageMapper;
import com.fafukeji.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fafukeji.service.IMessageService;

import java.util.List;

/**
 * Created by fafukeji_java on 2015/7/23.
 */
@Service("messageService")
public class MessageServiceImpl implements IMessageService {

    @Autowired
    public MessageMapper messageMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Message record) {
        return 0;
    }

    @Override
    public int insertSelective(Message record) {
        return messageMapper.insertSelective(record);
    }

    @Override
    public Message selectByPrimaryKey(Integer id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return messageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return 0;
    }

    @Override
    public List<Message> selectMessage(Message message) {
        return messageMapper.selectMessage(message);
    }
}
