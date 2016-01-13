package com.fafukeji.common.persistence.interceptor;

import com.fafukeji.common.mapper.JsonMapper;
import com.fafukeji.model.DeviceToken;
import com.fafukeji.model.ErrorInfo;
import com.fafukeji.service.IDeviceTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 手机端拦截器
 */
public class MobileInterceptor extends HandlerInterceptorAdapter {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/* 过滤不需要验证的url */
	private List<String> excludedUrls;

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}
    
    @Autowired
    private IDeviceTokenService deviceTokenService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestUri = request.getRequestURI();
		logger.debug("=====requestUri======" + requestUri);
		/* 判断是否需要过滤的页面 */
		for (String url : excludedUrls) {
			logger.debug("=====endsWith======" + url);
			if (requestUri.endsWith(url)) {
				return true;
			}
		}
		String accessToken = request.getParameter("access_token");
		if(null != accessToken && !"".equals(accessToken)){
			DeviceToken deviceToken = new DeviceToken();
			deviceToken.setDeviceToken(accessToken);
			DeviceToken resultDeviceToken = deviceTokenService.getByDeviceToken(deviceToken);
			if (null != resultDeviceToken){
				HttpSession session = request.getSession();
				session.setAttribute("userId", resultDeviceToken.getUserId());
				logger.debug("=====userId======" + resultDeviceToken.getUserId());
				return true;
			}
		}
		response.reset();
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setMessage("签名异常，请重新登陆！");
		try {
			response.getWriter().print(
					JsonMapper.toJsonString(errorInfo));
			return false;
		} catch (IOException e) {
			logger.error(e.getMessage());
			return false;
		}
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
