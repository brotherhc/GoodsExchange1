package com.fafukeji.common.persistence.interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fafukeji.common.config.Global;
import com.fafukeji.common.mapper.JsonMapper;
import com.fafukeji.common.utils.CookieUtils;
import com.fafukeji.common.web.Servlets;
import com.fafukeji.model.ErrorInfo;
import com.fafukeji.model.SessionInfo;
import com.fafukeji.model.User;
import com.fafukeji.service.IUserService;
import com.fafukeji.utils.UserUtils;

/**
 * 用户安全性拦截器
 */
public class UserSecurityInterceptor extends HandlerInterceptorAdapter {
	protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IUserService userService;
	
	/* 过滤不需要验证的url */
	private List<String> excludedUrls;

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestUri = request.getRequestURI();
		logger.error("=====requestUri======" + requestUri);
		for (String url : excludedUrls) {
			logger.error("=====endsWith======" + url);
			if (requestUri.endsWith(url)) {
				return true;
			}
		}

		/* 判断是否需要过滤的页面 */
		HttpSession session = request.getSession();
		logger.debug("====session====" + session.getAttribute(Global.getConfig("user_info")));
		if (session.getAttribute(Global.getConfig("user_info")) == null || ("").equals(session.getAttribute(Global.getConfig("user_info")))) {
			logger.debug("====cookie====" + UserUtils.verifyLoginCookie(request, response));
			if (UserUtils.verifyLoginCookie(request, response)){
        		String user_id = CookieUtils.getCookie(request, "user_id");
        		User user = userService.selectUserById(Integer.parseInt(user_id));
        		UserUtils.sessionUserInfo(request, user);
        		return true;
        	} 
			if (Servlets.isAjaxRequest(request)) {
				response.reset();
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setMessage("登陆超时,请重新登陆！");
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
		HttpSession session = request.getSession();
		if(session.getAttribute(Global.getConfig("user_info")) != null && !("").equals(session.getAttribute(Global.getConfig("user_info")))  && arg3!=null){
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Global.getConfig("user_info"));
			if (sessionInfo!=null){
				arg3.addObject("username", sessionInfo.getUsername());
				arg3.addObject("isAdmin", sessionInfo.getIsAdmin());
				logger.debug("======isAdmin===" + sessionInfo.getIsAdmin());
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

}
