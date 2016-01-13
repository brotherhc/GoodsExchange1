package com.fafukeji.controller;

import com.fafukeji.common.config.Global;
import com.fafukeji.common.utils.Constants;
import com.fafukeji.common.utils.DateUtils;
import com.fafukeji.common.utils.Message;
import com.fafukeji.common.utils.RandomUtil;
import com.fafukeji.model.MessageInfo;
import com.fafukeji.model.MobileCaptcha;
import com.fafukeji.model.SessionInfo;
import com.fafukeji.model.User;
import com.fafukeji.service.IMobileCaptchaService;
import com.fafukeji.service.IUserService;
import com.fafukeji.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * Created by java on 2015/8/31 0031.
 */
    @Controller
    @RequestMapping({"${adminPath}/balance"})
    public class RegisterController extends BaseController {

        @Autowired
        private IMobileCaptchaService mobileCaptchaService;
        @Autowired
      private SystemService systemService;
        @Autowired
        private IUserService userService;

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.POST)
    public String getVerificationCode(User user, HttpServletRequest request,
                                      HttpServletResponse response, Model model) {
        log.debug("<<<<<<<<<<<<<<<<<<<<<<<"+user.getMobile());
        if (user.getMobile() == null){
            addMessage(model, false, "用户的手机号码不能为空！");
            return renderString(response, model);
        }
        systemService.getCaptchaAndSendMsg(user.getMobile(), "");
        addMessage(model, true, "获取成功！");
        return renderString(response, model);
    }

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
