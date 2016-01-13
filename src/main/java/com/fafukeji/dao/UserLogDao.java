package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.UserLog;

@MyBatisDao
public interface UserLogDao {
	int deleteByPrimaryKey(String id);

	int insert(UserLog record);

	int insertSelective(UserLog record);

	UserLog selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(UserLog record);

	int updateByPrimaryKey(UserLog record);
}