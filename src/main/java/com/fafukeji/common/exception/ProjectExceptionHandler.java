package com.fafukeji.common.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fafukeji.common.mapper.JsonMapper;
import com.fafukeji.common.utils.Exceptions;
import com.fafukeji.common.web.Servlets;
import com.fafukeji.model.ErrorInfo;
import com.fafukeji.utils.LogUtils;

public class ProjectExceptionHandler implements HandlerExceptionResolver {
	private static Logger logger = Logger
			.getLogger(ProjectExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		logger.error("Catch Exception: ", arg3);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorMsg", Exceptions.getStackTraceAsString(arg3));// 将错误信息传递给view
		LogUtils.saveLog(arg0, arg2, arg3, null);
		if (Servlets.isAjaxRequest(arg0))// 如果是ajax请求响应头会有，x-requested-with；
		{
			arg1.reset();
			arg1.setContentType("application/json");
			arg1.setCharacterEncoding("utf-8");
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setMessage("请求异常，请稍后重试！");
			errorInfo.setSuccess(0);
			errorInfo.setState(ErrorInfo.STATE_ERROR);
			try {
				arg1.getWriter().print(JsonMapper.toJsonString(errorInfo));
				return null;
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		logger.debug("test1111111");
		return new ModelAndView("error/500", map);
	}
}
