package com.fafukeji.common.persistence.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fafukeji.common.config.Global;
import com.fafukeji.common.mapper.JsonMapper;
import com.fafukeji.common.web.Servlets;
import com.fafukeji.model.ErrorInfo;
import com.fafukeji.model.SessionInfo;
import com.fafukeji.model.User;

/**
 * 管理员安全性拦截器
 */
public class AdminSecurityInterceptor extends HandlerInterceptorAdapter {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		/* 判断是否需要过滤的页面 */
		HttpSession session = request.getSession();
		if (session.getAttribute(Global.getConfig("user_info")) != null) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Global.getConfig("user_info"));
			if (sessionInfo==null){
				return true;
			}
			if (sessionInfo.getIsAdmin() == User.ADMIN){
				return true;
			}
			if (Servlets.isAjaxRequest(request)) {
				response.reset();
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setMessage("你不是管理员,你没有访问该路径的权限！");
				errorInfo.setSuccess(0);
				errorInfo.setState(ErrorInfo.STATE_TIMEOUT);
				try {
					response.getWriter().print(
							JsonMapper.toJsonString(errorInfo));
					return false;
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			} else {
				/* 跳转到登录页 */
				request.getRequestDispatcher(
						"/WEB-INF/views/login.jsp").forward(
						request, response);
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

}
