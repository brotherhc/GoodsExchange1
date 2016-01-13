package com.fafukeji.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;


import com.fafukeji.common.utils.Exceptions;
import com.fafukeji.common.utils.SpringContextHolder;
import com.fafukeji.common.utils.StringUtils;
import com.fafukeji.controller.UserController;
import com.fafukeji.dao.UserLogDao;
import com.fafukeji.model.UserLog;
import com.fafukeji.model.User;


/**
 * 字典工具类
 */
public class LogUtils {
	
	
	private static UserLogDao logDao = SpringContextHolder.getBean(UserLogDao.class);
	
	public static Logger logger = Logger.getLogger(UserController.class);
	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, String type){
		saveLog(request, null, null, type);
	}
	
	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String type){
		User user = UserUtils.getUser();
		UserLog log = new UserLog();
		log.setType(type);
		log.setRemoteAddr(StringUtils.getRemoteAddr(request));
		logger.error(ex);
		log.setRequestUri(request.getRequestURI());
		log.setParams(request.getParameterMap().toString());
		log.setMethod(request.getMethod());
		if (user != null && user.getId() != null){
			log.setUserId(user.getId());
		}
		// 异步保存日志
		new SaveLogThread(log, handler, ex).start();
	}

	/**
	 * 保存日志线程
	 */
	public static class SaveLogThread extends Thread{
		
		private UserLog log;
		private Object handler;
		private Exception ex;
		
		public SaveLogThread(UserLog log, Object handler, Exception ex){
			super(SaveLogThread.class.getSimpleName());
			this.log = log;
			this.handler = handler;
			this.ex = ex;
		}
		
		@Override
		public void run() {
			
			// 如果有异常，设置异常信息
			log.setException(Exceptions.getStackTraceAsString(ex));
			// 保存日志信息
//			log.preInsert();---
			logDao.insertSelective(log);
		}
	}

	
}
