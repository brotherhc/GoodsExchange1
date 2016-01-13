package com.fafukeji.service;

import com.fafukeji.common.config.Global;
import com.fafukeji.common.utils.*;
import com.fafukeji.model.MessageInfo;
import com.fafukeji.model.MobileCaptcha;
import com.fafukeji.model.SessionInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service("systemService")
public class SystemService {
	//用户
	@Autowired
	private IUserService userService;
	//关键字
//	@Autowired
//	private ISystemSettingService systemSettingService;
	@Autowired
	private IMobileCaptchaService mobileCaptchaService;
	public static Logger log = Logger.getLogger(SystemService.class);

	/**
	 * 根据设置的关键字获取设置，并且进行缓存
	 * 
	 * @param keyword
	 * @return
	 */
//	public SystemSetting getSystemSettingByKeyword(String keyword) {
//		SystemSetting systemSetting = (SystemSetting) CacheUtils.get(keyword);
//		log.error("====SystemService cache=======" + systemSetting);
//		if (systemSetting == null) {
//			log.error("====SystemService=======");
//			systemSetting = new SystemSetting();
//			systemSetting.setKeyword(keyword);
//			systemSetting = systemSettingService.findByProps(systemSetting);
//			CacheUtils.put(keyword, systemSetting);
//		}
//		log.error("====SystemService=======" + systemSetting.getUserId());
//		return systemSetting;
//	}

	/**
	 * 获取验证码并且发送短信
	 * 
	 * @param mobile
	 */
	public void getCaptchaAndSendMsg(String mobile, String msg) {
		int captcha = RandomUtil.getSixLengthRandomNum();
		MobileCaptcha mobileCaptcha = new MobileCaptcha();
		mobileCaptcha.setCaptcha(captcha + "");
		mobileCaptcha.setMobile(mobile);
		mobileCaptchaService.insertSelective(mobileCaptcha);
    	MessageInfo messageInfo = new MessageInfo();
		messageInfo.setMobiles(mobile);
		messageInfo.setContents(String.format(Constants.CAPTCHA_CONTENT, captcha));
    	Message.sendMessage(messageInfo);
	}


	/**
	 * 从session中获取用户名
	 * @param request
	 * @return
	 */
	public String getUsername(HttpServletRequest request){
		HttpSession session = request.getSession();
    	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Global.getConfig("user_info"));
    	return sessionInfo.getUsername();
	}
	


	/**
	 * 验证验证码是否正确
	 * @param mobile
	 * @param captcha
	 * @return
	 */
	public boolean judgeCaptchaRight(String mobile, String captcha){
		MobileCaptcha mobileCaptcha = new MobileCaptcha();
        mobileCaptcha.setValidTime(DateUtils.getCurrentTimeStamp());
        mobileCaptcha.setCaptcha(captcha);
        mobileCaptcha.setMobile(mobile);
        //验证验证码是否正确
        if (mobileCaptchaService.getByProps(mobileCaptcha) == null) {
            return false;
        }
        return true;
	}
	
	public Object getObjectFromSession(HttpServletRequest request, String key){
		HttpSession session = request.getSession();
		return session.getAttribute(key);
	}
}
