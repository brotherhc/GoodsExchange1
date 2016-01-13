package com.fafukeji.service;

import com.fafukeji.common.utils.Message;
import com.fafukeji.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userService")
public interface IUserService {

	List<User> getAll(User user);
	List<User> selectUser(User user);
	User selectUserById(Integer id);
    User userInfo(String username);
    String update(User userInfo);
    int deleteUserById(Integer id);
    List<User> getByMobileOrUsername(User user);

    List<User>selecteid(User user);
    List<User> getByUsername(User user);
    
    List<User> getByMobile(User user);
    
    List<User> getByMobileAndUsername(User user);
    
    List<User> getByState(User user);
    
    User getByAgentKey(User user);
    int updateByPrimaryKeySelective(User user);
    int updateUserImei(User user);
    int insert(User user);

    int insertSelective(User user);

    List<User> selectUser(String username, String password);

    boolean validatePassword(String password, String password1);
}
