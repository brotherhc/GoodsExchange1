package com.fafukeji.service.impl;


import com.fafukeji.common.utils.Message;
import com.fafukeji.dao.UserDao;
import com.fafukeji.model.User;
import com.fafukeji.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements IUserService {
	private UserDao userDao;
		

	public UserDao getUserDao() {
		return userDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public List<User> getAll(User user) {
		return userDao.getAll(user);
	}

	@Override
	public List<User> selectUser(User user) {
		return userDao.selectUser(user);
	}


//	@Override
//	public String userInfo(User userInfo) {
//		if (userDao.insertSelective(userInfo) == 1) {
//			return "添加成功";
//		}
//		return "添加失败";
//		//return userDao.insertSelective(User);
//	}

	@Override
	public String update(User userInfo) {
		if (userDao.updateByPrimaryKeySelective(userInfo )== 1){
				return "更新成功";
		}
				return "更新失败";
		//return userDao.updateByPrimaryKey(muser);
	}

	@Override
	public int deleteUserById(Integer id) {
		return userDao.deleteUserById(id);
	}




	@Override
	public User selectUserById(Integer id) {
		return userDao.selectUserById(id);
	}

	@Override
	public User userInfo(String username) {
		return  userDao.userInfo(username);
	}


	@Override
	public List<User> getByMobileOrUsername(User user) {
		return userDao.getByMobileOrUsername(user);
	}

	@Override
	public List<User> selecteid(User user) {
		return userDao.selecteid(user);
	}

	@Override
	public List<User> getByUsername(User user) {
		return userDao.getByUsername(user);
	}

	@Override
	public List<User> getByMobile(User user) {
		return userDao.getByMobile(user);
	}

	@Override
	@Transactional(readOnly=false)
	public int updateByPrimaryKeySelective(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public User getByAgentKey(User user) {
		return userDao.getByAgentKey(user);
	}

	@Override
	public List<User> getByState(User user) {
		return userDao.getByState(user);
	}
	@Override
	public int updateUserImei(User user) {
		return userDao.updateUserImei(user);
	}

	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public int insertSelective(User user) {
		return userDao.insertSelective(user);
	}

	@Override
	public List<User> selectUser(String username, String password) {
		return userDao.selectUser(username,password);
	}

	@Override
	public boolean validatePassword(String password, String password1) {
		return false;
	}


	@Override
	public List<User> getByMobileAndUsername(User user) {
		return userDao.getByMobileAndUsername(user);
	}



}
