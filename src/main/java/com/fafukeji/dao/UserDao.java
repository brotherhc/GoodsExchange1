package com.fafukeji.dao;

import com.fafukeji.common.persistence.annotation.MyBatisDao;
import com.fafukeji.model.User;

import java.util.List;

@MyBatisDao
public interface UserDao {
	int deleteUserById(Integer id);
	int insertSelective(User user);
	List<User> selectUser(User user);
	User selectUserById(Integer id);
	int updateByPrimaryKeySelective(User record);
	int updateByPrimaryKey(User record);
	User userInfo(String username);
	List<User> getAll(User user);
	List<User> getByMobileOrUsername(User user);
	List<User> getByMobile(User user);
	List<User> getByState(User user);
	List<User>selecteid(User user);
	User getByAgentKey(User user);
	
	int updateUserImei(User user);

	List<User> getByMobileAndUsername(User user);
	int insert(User user);
	List<User> getByUsername(User user);

	List<User> selectUser(String username, String password);
}