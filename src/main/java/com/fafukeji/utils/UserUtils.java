package com.fafukeji.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fafukeji.common.config.Global;
import com.fafukeji.common.security.Digests;
import com.fafukeji.common.utils.CacheUtils;
import com.fafukeji.common.utils.Constants;
import com.fafukeji.common.utils.CookieUtils;
import com.fafukeji.common.utils.RandomUtil;
import com.fafukeji.common.utils.SpringContextHolder;
import com.fafukeji.common.utils.Encodes;
import com.fafukeji.common.utils.StringUtils;
import com.fafukeji.model.SessionInfo;
import com.fafukeji.dao.UserDao;
import com.fafukeji.model.User;

/**
 * 用户工具类
 */
public class UserUtils {
	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_NAME_ = "name_";
	private static final int SALT_SIZE = 8;
	private static final int HASH_INTERATIONS = 1024;

	/**
	 * 根据ID获取用户
	 * 
	 * @param id
	 * @return 取不到返回null
	 */
	public static User getFromCache(Integer id) {
		User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
		if (user == null) {
			user = userDao.selectUserById(id);
			if (user == null) {
				return null;
			}
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_NAME_ + user.getImei(), user);
		}
		return user;
	}
	
	/**
	 * 根据ID获取用户
	 * 
	 * @param id
	 * @return 取不到返回null
	 */
	public static User get(Integer id) {
		User user = userDao.selectUserById(id);
		return user;
	}

	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static User getUser() {
		
		return new User();
	}
	
	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 * @param plainPassword 明文密码
	 */
	public static String entryptPassword(String plainPassword) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}
	
	
	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		byte[] salt = Encodes.decodeHex(password.substring(0,16));
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
	}

	public static void sessionUserInfo(HttpServletRequest request,User loginUser){
		if (loginUser == null){
			return;
		}
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setUserId(loginUser.getId());
		sessionInfo.setIsAdmin(loginUser.getIsAdmin());
		sessionInfo.setUsername(loginUser.getUsername());
		HttpSession session = request.getSession();
		session.setAttribute(Global.getConfig("user_info"), sessionInfo);
	}
	
	public static boolean verifyLoginCookie(HttpServletRequest request, HttpServletResponse response){
		if (request == null || response == null || CookieUtils.getCookie(request, "user_key") == null 
				|| CookieUtils.getCookie(request, "random_string") == null|| CookieUtils.getCookie(request, "user_id") == null){
			return false;
		}
		String ip = StringUtils.getRemoteAddr(request);
    	byte [] encrypt = Digests.md5((ip+CookieUtils.getCookie(request, "user_id") + CookieUtils.getCookie(request, "random_string")).getBytes());
    	if (encrypt.toString().equals(CookieUtils.getCookie(request, "user_key"))){
    		return true;
    	}
		return false;
	}
	
	
	public static HttpServletResponse generateLoginCookie(HttpServletRequest request, HttpServletResponse response, User loginUser, String path){
		String randomString = RandomUtil.getFixLengthInt(6);
    	String ip = StringUtils.getRemoteAddr(request);
    	byte [] encrypt = Digests.md5((ip + loginUser.getId() + randomString).getBytes());
		CookieUtils.setCookie(response, "user_key", encrypt.toString(), path, Constants.COOKIE_TIME);
		CookieUtils.setCookie(response, "user_id", loginUser.getId().toString(), path, Constants.COOKIE_TIME);
		CookieUtils.setCookie(response, "random_string", randomString, path, Constants.COOKIE_TIME);
		return response;
	}
	
	public static SessionInfo getSessionInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute(Global.getConfig("user_info")) == null){
			return null;
		}
		return (SessionInfo)(session.getAttribute(Global.getConfig("user_info")));
		
	}
	
}
